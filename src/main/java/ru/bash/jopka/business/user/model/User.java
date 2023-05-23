package ru.bash.jopka.business.user.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class User {
    private Long id;
    private String password;
    private String firstName;
    private String secondName;
    private String fatherName;
    private String email;
    private String phone;
    private String city;
    private String country;
    private String aboutMe;
    private String faculty;
    private String supervisorFullName;
    private String supervisorPosition;
    private String supervisorPhoneNumber;
    private LocalDate birthday;
    private long roleId;
    private long organizationId;
    private List<Long> picturesId;
}
