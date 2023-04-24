package ru.bash.jopka.controller.status.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateStatusRequest {
    @NotNull
    private String name;
}
