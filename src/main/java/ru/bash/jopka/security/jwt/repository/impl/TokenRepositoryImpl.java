package ru.bash.jopka.security.jwt.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.bash.jopka.security.jwt.model.JwtToken;
import ru.bash.jopka.security.jwt.repository.TokenRepository;
import ru.bash.jopka.security.jwt.repository.jpa.JpaToken;
import ru.bash.jopka.security.jwt.repository.jpa.JpaTokenMapper;
import ru.bash.jopka.security.jwt.repository.jpa.JpaTokenRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TokenRepositoryImpl implements TokenRepository {
    private final JpaTokenRepository repository;
    private final JpaTokenMapper mapper;
    @Override
    public Optional<JwtToken> find(long id) {
        return repository.findById(id)
                .map(mapper::fromJpa);
    }

    @Override
    public JwtToken update(JwtToken token) {
        JpaToken entity = repository.save(mapper.toJpa(token));
        return mapper.fromJpa(entity);
    }

    @Override
    public Optional<JwtToken> findByToken(String token) {
        return repository.findByToken(token)
                .map(mapper::fromJpa);
    }

    @Override
    public Optional<JwtToken> findByUserId(long userId) {
        return repository.findByUserId(userId)
                .map(mapper::fromJpa);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteByUserId(long userId) {
        repository.deleteByUserId(userId);
    }
}
