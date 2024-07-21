package com.thanhtan.identity.controller;

import com.thanhtan.identity.dto.response.ApiResponse;
import com.thanhtan.identity.dto.response.NotificationResponse;
import com.thanhtan.identity.service.INotificationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.thanhtan.identity.constant.PathConstant.API_V1_NOTIFICATION;

@RestController
@RequestMapping(API_V1_NOTIFICATION)
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NotificationController {

    INotificationService notificationService;

    @GetMapping
    ApiResponse<List<NotificationResponse>> getAllNotificationsByUser() {
        return ApiResponse.success(notificationService.getNotificationsByUser());
    }

    @PutMapping("/{id}")
    public ApiResponse<NotificationResponse> markAsSeen(@PathVariable Long id) {
        return ApiResponse.success(notificationService.markAsSeen(id));
    }


}
