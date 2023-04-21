package ru.bash.jopka.controller.dto.organization;

import lombok.Data;

@Data
public class UpdateOrganizationRequest {
    private long id;
    private String name;
    private String description;
}
