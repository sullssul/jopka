package ru.bash.jopka.business.organization.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Organization {
    private Long id;
    private String name;
    private String description;
}
