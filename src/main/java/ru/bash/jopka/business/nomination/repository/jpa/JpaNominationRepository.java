package ru.bash.jopka.business.nomination.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaNominationRepository extends JpaRepository<JpaNomination, Long> {
    Optional<JpaNomination> findByName(String name);
}
