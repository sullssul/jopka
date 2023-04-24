package ru.bash.jopka.controller.nomimation.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class UpdateNominationRequest {

    @Positive
    private long id;

    @NotEmpty
    private String name;
}
