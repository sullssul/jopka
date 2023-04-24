package ru.bash.jopka.business.status.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface JpaStatusRepository extends JpaRepository<JpaStatus, Long> {
    Optional<JpaStatus> findByName(String name);
}