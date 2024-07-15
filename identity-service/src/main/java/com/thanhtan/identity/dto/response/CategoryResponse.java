package com.thanhtan.identity.dto.response;

import com.thanhtan.identity.enums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryResponse extends BaseDTO{
    String name;
    String description;
    Status status;
}
