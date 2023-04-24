package ru.bash.jopka.controller.dto.status;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateStatusRequest {
    @NotNull
    private String name;
}
