package ru.bash.jopka.controller.user.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FindUserWithFilterRequest {
    private String firstName;
    private String secondName;
    private String fatherName;
    private String city;
    private String country;
    private LocalDate birthday;
    private String email;
    private String phone;
    private long organizationId = 0;
}
