package com.thanhtan.identity.service;

import com.thanhtan.identity.dto.request.NotificationRequest;
import com.thanhtan.identity.dto.response.NotificationResponse;
import com.thanhtan.identity.entity.User;

import java.util.List;

public interface INotificationService {
    void sendNotificationToAdmin(User user, Long orderId);

    void sendNotificationToUser(NotificationRequest notificationRequest, List<Long> userIds);

    void sendUpdateOrderNotificationToUser(Long orderId, Long id);

    List<NotificationResponse> getNotificationsByUser();

    NotificationResponse markAsSeen(Long notificationId);


}
