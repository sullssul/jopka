package ru.bash.jopka.business.organization.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface  JpaOrganizationRepository extends JpaRepository<JpaOrganization, Long> {
    Optional<JpaOrganization> findByName(String name);
}
