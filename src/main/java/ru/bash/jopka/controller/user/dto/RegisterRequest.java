package ru.bash.jopka.controller.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisterRequest {
    @NotEmpty(message = "First name cannot be empty")
    private String firstName;
    @NotEmpty(message = "Second name cannot be empty")
    private String secondName;
    private String fatherName;
    @NotEmpty
    private String city;
    @NotEmpty
    private String country;
    private String aboutMe;
    private String faculty;
    private String supervisorFullName;
    private String supervisorPosition;
    private String supervisorPhoneNumber;
    @NotNull
    private LocalDate birthday;
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
