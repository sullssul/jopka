package ru.bash.jopka.controller.dto.organization;

import lombok.Data;

@Data
public class CreateOrganizationRequest {
    private String name;
    private String description;
}

