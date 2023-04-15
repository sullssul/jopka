package ru.bash.jopka.business.role.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Role {
    private Long id;
    private String name;
}
