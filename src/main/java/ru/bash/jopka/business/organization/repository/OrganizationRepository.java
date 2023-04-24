package ru.bash.jopka.business.organization.repository;

import ru.bash.jopka.business.organization.model.Organization;

import java.util.Optional;
import java.util.Set;

public interface OrganizationRepository {
    Optional<Organization> find(long id);
    Organization update(Organization organization);
    Optional<Organization> findByName(String name);
    Set<Organization> findAll();
    void delete(long id);
}
