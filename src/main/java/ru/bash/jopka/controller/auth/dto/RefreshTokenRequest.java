package ru.bash.jopka.controller.auth.dto;

import lombok.Data;

@Data
public class RefreshTokenRequest {
    private String token;
}
