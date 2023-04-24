package ru.bash.jopka.controller.dto.error;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class ErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    private String details;

}
