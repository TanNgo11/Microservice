package com.thanhtan.identity.dto.request;

import com.thanhtan.identity.enums.Status;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @Size(min = 8, max = 20, message = "USERNAME_INVALID")
    String username;
    @Size(min = 8, max = 20, message = "INVALID_PASSWORD")
    String password;

    @Builder.Default
    Status status = Status.ACTIVE;
}
