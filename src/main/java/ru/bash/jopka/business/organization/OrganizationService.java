package ru.bash.jopka.business.organization;

import ru.bash.jopka.controller.organization.dto.CreateOrganizationRequest;
import ru.bash.jopka.controller.organization.dto.UpdateOrganizationRequest;
import ru.bash.jopka.business.organization.model.Organization;

import java.util.Optional;
import java.util.Set;

public interface OrganizationService {
    Organization update(UpdateOrganizationRequest request);
    Organization create(CreateOrganizationRequest request);
    Optional<Organization> find(long id);
    String delete(long id);
    Set<Organization> findAll();
}
