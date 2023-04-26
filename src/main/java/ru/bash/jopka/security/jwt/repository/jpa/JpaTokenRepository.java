package ru.bash.jopka.security.jwt.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaTokenRepository extends JpaRepository<JpaToken, Long> {
    Optional<JpaToken> findByToken(String token);
    Optional<JpaToken> findByUserId(long userId);
    void deleteByUserId(long userId);
}
