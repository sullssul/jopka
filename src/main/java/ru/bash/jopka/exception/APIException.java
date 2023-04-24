package ru.bash.jopka.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
public class APIException extends RuntimeException {
    private final HttpStatus status;
    private final String message;

    public APIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}