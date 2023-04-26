package ru.bash.jopka.security.jwt.usecase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.security.jwt.model.JwtToken;
import ru.bash.jopka.security.jwt.repository.TokenRepository;

import java.util.Optional;


@Component
@RequiredArgsConstructor
public class CreateTokenCommand {
    private final TokenRepository repository;
    private final FindTokenByUserIdQuery findTokenByUserIdQuery;

    @Transactional
    public JwtToken execute(JwtToken token) {
        token.setId(0);
        Optional<JwtToken> existToken = findTokenByUserIdQuery.execute(token.getUserId());
        if (existToken.isPresent()) {
            token.setId(existToken.get().getId());
        }
        token = repository.update(token);
        return token;
    }
}
