package ru.bash.jopka.security.jwt;

import ru.bash.jopka.business.user.model.User;
import ru.bash.jopka.security.jwt.model.JwtToken;

public interface JwtTokenService {
    JwtToken createToken(User user);
    String getUserNameFromToken(String token);
    JwtToken refreshToken(String oldToken);
    boolean validateJwtToken(String token);
    void deleteTokenByEmail(String email);
}
