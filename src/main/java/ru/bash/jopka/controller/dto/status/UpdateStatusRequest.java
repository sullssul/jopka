package ru.bash.jopka.controller.dto.status;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UpdateStatusRequest {
    private long id;

   @NotEmpty
   private String name;
}
