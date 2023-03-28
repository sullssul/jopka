package ru.bash.jopka.business.user.model;

import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    private ZonedDateTime birthday;
    private long roleId;
    private long organizationId;
    private List<Long> picturesId;
}
