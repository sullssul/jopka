package ru.bash.jopka.controller.role.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class UpdateRoleRequest {
    @Positive
    private long id;
    @NotEmpty
    private String name;
}
