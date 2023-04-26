package ru.bash.jopka.security.jwt.repository;

import ru.bash.jopka.security.jwt.model.JwtToken;

import java.util.Optional;

public interface TokenRepository {
    Optional<JwtToken> find(long id);
    JwtToken update(JwtToken token);
    Optional<JwtToken> findByToken(String token);
    Optional<JwtToken> findByUserId(long userId);
    void delete(long id);
    void deleteByUserId(long userId);
}
