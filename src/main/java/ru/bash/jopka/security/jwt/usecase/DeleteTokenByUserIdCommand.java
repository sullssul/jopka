package ru.bash.jopka.security.jwt.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.security.jwt.repository.TokenRepository;
@Component
@RequiredArgsConstructor
public class DeleteTokenByUserIdCommand {
    private final TokenRepository repository;
    private final GetTokenByUserIdQuery getTokenByUserIdQuery;

    public void execute(long userId) {
        getTokenByUserIdQuery.execute(userId);
        repository.deleteByUserId(userId);
    }
}
