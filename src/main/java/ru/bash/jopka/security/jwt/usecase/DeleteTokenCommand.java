package ru.bash.jopka.security.jwt.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.security.jwt.repository.TokenRepository;

@Component
@RequiredArgsConstructor
public class DeleteTokenCommand {
    private final TokenRepository repository;
    private final GetTokenQuery getUserQuery;

    public void execute(long id) {
        getUserQuery.execute(id);
        repository.delete(id);
    }
}
