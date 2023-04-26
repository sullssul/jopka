package ru.bash.jopka.security.jwt.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import ru.bash.jopka.exception.APIException;
import ru.bash.jopka.security.jwt.model.JwtToken;
import ru.bash.jopka.security.jwt.repository.TokenRepository;

@Component
@RequiredArgsConstructor
public class GetTokenQuery {
    private final TokenRepository repository;

    public JwtToken execute(long id) {
        return repository.find(id)
                .orElseThrow(() ->
                        new APIException(HttpStatus.NOT_FOUND, "JWT токен c id: " + id + " - не найден!")
                );
    }
}
