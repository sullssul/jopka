package ru.bash.jopka.controller.dto.role;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UpdateRoleRequest {

    private long id;
    @NotEmpty
    private String name;
}
