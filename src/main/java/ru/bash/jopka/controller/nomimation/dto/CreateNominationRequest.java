package ru.bash.jopka.controller.nomimation.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateNominationRequest {

    @NotEmpty
    private String name;

}
