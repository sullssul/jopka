package ru.bash.jopka.controller.dto.Organization;

import lombok.Data;

@Data
public class UpdateOrganizationRequest {
    private long id;
    private String name;
    private String description;
}
