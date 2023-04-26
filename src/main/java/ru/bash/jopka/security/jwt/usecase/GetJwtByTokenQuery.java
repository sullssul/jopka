package ru.bash.jopka.security.jwt.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import ru.bash.jopka.exception.APIException;
import ru.bash.jopka.security.jwt.model.JwtToken;
import ru.bash.jopka.security.jwt.repository.TokenRepository;

@Component
@RequiredArgsConstructor
public class GetJwtByTokenQuery {
    private final TokenRepository repository;

    public JwtToken execute(String token) {
        return repository.findByToken(token)
                .orElseThrow(() ->
                        new APIException(HttpStatus.NOT_FOUND, "JWT токен: " + token + " - не найден!")
                );
    }
}
