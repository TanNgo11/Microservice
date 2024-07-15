package com.thanhtan.identity.dto.request;

import com.thanhtan.identity.enums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateCategoryRequest {
    Long id;
    String name;
    String description;
    Status status;
}
