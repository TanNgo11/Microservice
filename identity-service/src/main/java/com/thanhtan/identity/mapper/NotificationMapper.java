package com.thanhtan.identity.mapper;

import com.thanhtan.identity.dto.request.NotificationRequest;
import com.thanhtan.identity.dto.response.NotificationResponse;
import com.thanhtan.identity.entity.Notification;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    NotificationResponse toNotificationResponse(Notification notification);

    Notification toNotification(NotificationRequest notificationRequest);

    List<NotificationResponse> toNotificationResponseList(List<Notification> notifications);



}
