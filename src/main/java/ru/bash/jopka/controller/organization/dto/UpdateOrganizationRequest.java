package ru.bash.jopka.controller.organization.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UpdateOrganizationRequest {
    private long id;
    @NotEmpty
    private String name;
    private String description;
}
