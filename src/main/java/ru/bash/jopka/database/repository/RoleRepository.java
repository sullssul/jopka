package ru.bash.jopka.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bash.jopka.business.role.repository.jpa.JpaRole;

@Repository
public interface RoleRepository extends JpaRepository<JpaRole, Long> {
    JpaRole findRoleById(Long id);
}
