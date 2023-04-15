package ru.bash.jopka.business.role.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaRoleRepository extends JpaRepository<JpaRole, Long> {
    Optional<JpaRole> findByName(String name);
}
