package ru.bash.jopka.controller.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.ZonedDateTime;

public class UpdateUserRequest {
    @NotEmpty(message = "First name cannot be empty")
    private String firstName;
    @NotEmpty(message = "Second name cannot be empty")
    private String secondName;
    private String fatherName;
    private ZonedDateTime birthday;
    @Email(message = "Не валидное значение email!", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotEmpty(message = "Email cannot be empty")
    private String email;
    @NotEmpty(message = "Password cannot be empty")
    private String password;
    @NotEmpty(message = "Phone cannot be empty")
    private String phone;
    @Positive
    private long organizationId;
    @Positive
    private long roleId;
}
