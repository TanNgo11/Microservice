package com.thanhtan.identity.dto.request;

import com.thanhtan.identity.enums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryRequest {
    String name;
    String description;
    @Builder.Default
    Status status = Status.ACTIVE;
}
