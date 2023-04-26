package ru.bash.jopka.security.jwt.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.security.jwt.model.JwtToken;
import ru.bash.jopka.security.jwt.repository.TokenRepository;

@Component
@RequiredArgsConstructor
public class UpdateTokenCommand {
    private final TokenRepository repository;
    private final GetTokenQuery getQuery;

    public JwtToken execute(JwtToken jwtToken) {
        JwtToken token = getQuery.execute(jwtToken.getId());
        token.setAccessToken(jwtToken.getAccessToken());
        token.setExpiryDate(jwtToken.getExpiryDate());
        return repository.update(token);
    }

}
