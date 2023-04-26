package ru.bash.jopka.security.jwt.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import ru.bash.jopka.exception.APIException;
import ru.bash.jopka.security.jwt.model.JwtToken;

@Component
@RequiredArgsConstructor
public class GetTokenByUserIdQuery {
    private final FindTokenByUserIdQuery findByUserIdQuery;
    public JwtToken execute(long userId) {
        return findByUserIdQuery.execute(userId)
                .orElseThrow(() ->
                        new APIException(HttpStatus.NOT_FOUND, "JWT токен для пользователя с id: " + userId + " - не найден!")
                );
    }
}
