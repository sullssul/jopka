package ru.bash.jopka.Controller.register.dto;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class RegisterRequest {
    private String userName;
    private String firstName;
    private String SecondName;
    private String fatherName;
    private ZonedDateTime birthday;
    private String email;
    private String password;
    private String phone;
    private long organizationId;
    private long roleId;
}
