package com.shadcn.profileservice.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProfileCreationRequest {
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    String gender;
    @DobConstraint(min = 18, message = "INVALID_DOB")
    LocalDate dateOfBirth;
    @Builder.Default
    Status status = Status.ACTIVE;
}