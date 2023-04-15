package ru.bash.jopka.controller.dto.Organization;

import lombok.Data;

@Data
public class CreateOrganizationRequest {
    private String name;
    private String description;
}

