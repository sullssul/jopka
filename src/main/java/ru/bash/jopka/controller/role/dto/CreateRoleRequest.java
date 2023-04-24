package ru.bash.jopka.controller.role.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateRoleRequest {
    @NotEmpty
    private String name;
}
