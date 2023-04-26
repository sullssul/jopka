package ru.bash.jopka.security.auth;

import ru.bash.jopka.controller.auth.dto.LoginRequest;
import ru.bash.jopka.controller.auth.dto.RefreshTokenRequest;
import ru.bash.jopka.security.jwt.model.JwtToken;


public interface AuthService {
    JwtToken authAndCreateToken(LoginRequest request);

    JwtToken refreshToken(RefreshTokenRequest request);

    String logout();
}
