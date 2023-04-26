package ru.bash.jopka.security.jwt.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.security.jwt.model.JwtToken;
import ru.bash.jopka.security.jwt.repository.TokenRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindTokenQuery {
    private final TokenRepository repository;
    public Optional<JwtToken> execute(long id) {
        return repository.find(id);
    }
}
