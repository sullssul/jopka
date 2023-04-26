package ru.bash.jopka.security.jwt.model;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class JwtToken {
    private long id;
    private String accessToken;
    private long userId;
    private String type;
    private Instant expiryDate;
}
