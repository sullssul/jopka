package ru.bash.jopka.controller.organization.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateOrganizationRequest {
    @NotEmpty
    private String name;
    private String description;
}

