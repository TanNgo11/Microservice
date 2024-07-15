package com.thanhtan.identity.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {
    String title;
    String content;
    String linkUrl;
}
