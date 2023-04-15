package ru.bash.jopka.business.organization.repository;

import ru.bash.jopka.business.organization.model.Organization;

import java.util.Set;

public interface OrganizationRepository {
    Organization find(long id);
    Organization update(Organization organization);
    Organization findByName(String name);
    Set<Organization> findAll();
    void delete(long id);
}
