package ru.bash.jopka.business.organization;

import ru.bash.jopka.controller.dto.Organization.CreateOrganizationRequest;
import ru.bash.jopka.controller.dto.Organization.UpdateOrganizationRequest;
import ru.bash.jopka.business.organization.model.Organization;

import java.util.Set;

public interface OrganizationService {
    Organization update(UpdateOrganizationRequest request);
    Organization create(CreateOrganizationRequest request);
    Organization find(long id);
    String delete(long id);
    Set<Organization> findAll();
}
