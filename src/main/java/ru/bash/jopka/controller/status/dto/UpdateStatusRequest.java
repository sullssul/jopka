package ru.bash.jopka.controller.status.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class UpdateStatusRequest {
    @Positive
    private long id;
    @NotEmpty
    private String name;
}
