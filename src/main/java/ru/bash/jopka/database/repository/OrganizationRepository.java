package ru.bash.jopka.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bash.jopka.database.model.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
