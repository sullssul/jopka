package ru.bash.jopka.business.user.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaUserRepository extends JpaRepository<JpaUser, Long> {
    Optional<JpaUser> findByEmail(String email);
    List<JpaUser> findAllByEmailLike(String email);
}
