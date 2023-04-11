package ru.bash.jopka.Controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotEmpty(message = "First name cannot be empty")
    private String firstName;
    @NotEmpty(message = "Second name cannot be empty")
    private String secondName;
    private String fatherName;
    private String city;
    private String country;
    private String aboutMe;
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
