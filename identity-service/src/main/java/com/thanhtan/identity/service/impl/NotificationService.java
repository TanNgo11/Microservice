package com.thanhtan.identity.service.impl;

import com.thanhtan.identity.dto.request.NotificationRequest;
import com.thanhtan.identity.dto.response.NotificationResponse;
import com.thanhtan.identity.entity.Notification;
import com.thanhtan.identity.entity.Role;
import com.thanhtan.identity.entity.User;
import com.thanhtan.identity.exception.AppException;
import com.thanhtan.identity.exception.ErrorCode;
import com.thanhtan.identity.mapper.NotificationMapper;
import com.thanhtan.identity.repository.NotificationRepository;
import com.thanhtan.identity.repository.RoleRepository;
import com.thanhtan.identity.repository.UserRepository;
import com.thanhtan.identity.service.INotificationService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NotificationService implements INotificationService {

    SimpMessagingTemplate messagingTemplate;

    NotificationRepository notificationRepository;

    NotificationMapper notificationMapper;


    UserRepository userRepository;

    RoleRepository roleRepository;

    @Override
    @Transactional
    public void sendNotificationToAdmin(User user, Long orderId) {
        NotificationRequest notificationRequest =
                NotificationRequest.builder()
                        .title("New Order")
                        .content(user.getFirstName() + user.getLastName() + " has placed a new order.")
                        .linkUrl("/admin/orders/"+orderId)
                        .build();

        Optional<Role> adminRole = roleRepository.findByName("ADMIN");
        List<User> adminUsers = userRepository.findAllByRolesContains(adminRole.get());
        Notification notification = notificationMapper.toNotification(notificationRequest);
        for (User admin : adminUsers) {
            notification.setUser(admin);
            notificationRepository.save(notification);
            messagingTemplate.convertAndSendToUser(
                    admin.getUsername(), "/queue/notification", notificationRequest
            );
        }

    }

    @Override
    public List<NotificationResponse> getNotificationsByUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        List<Notification> notifications = notificationRepository.findByUserOrderByCreatedDateDesc(user);
        return notificationMapper.toNotificationResponseList(notifications);
    }

    @Override
    @Transactional
    public NotificationResponse markAsSeen(Long notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new AppException(ErrorCode.NOTIFICATION_NOT_EXISTED));
        notification.setSeen(true);
        notification = notificationRepository.save(notification);
        return notificationMapper.toNotificationResponse(notification);
    }

    @Override
    public void sendUpdateOrderNotificationToUser(Long orderId, Long id) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new AppException(ErrorCode.USER_NOT_EXISTED);
        }
        NotificationRequest notificationRequest = NotificationRequest.builder()
                .title("Order Updated")
                .content("Your order has been updated")
                .linkUrl("/user/orders/" + orderId)
                .build();

        Notification notification = notificationMapper.toNotification(notificationRequest);
        notification.setUser(user);
        notificationRepository.save(notification);
        messagingTemplate.convertAndSendToUser(
                user.getUsername(), "/queue/notification", notificationRequest
        );
    }

    @Override
    public void sendNotificationToUser(NotificationRequest notificationRequest, List<Long> userIds) {
        List<User> users = userRepository.findUsersByIds(userIds);
        for (User user : users) {
            Notification notification = notificationMapper.toNotification(notificationRequest);
            notification.setUser(user);
            notificationRepository.save(notification);
            messagingTemplate.convertAndSendToUser(
                    user.getUsername(), "/queue/notification", notificationRequest
            );
        }
    }
}
