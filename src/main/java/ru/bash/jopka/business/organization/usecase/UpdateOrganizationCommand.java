package ru.bash.jopka.business.organization.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.organization.model.Organization;
import ru.bash.jopka.business.organization.repository.OrganizationRepository;
import ru.bash.jopka.controller.organization.dto.UpdateOrganizationRequest;

@Component
@RequiredArgsConstructor
public class UpdateOrganizationCommand {
    private final OrganizationRepository repository;
    private final GetOrganizationQuery getQuery;
    private final VerifyOrganizationQuery verifyQuery;

    public Organization execute(UpdateOrganizationRequest request) {
        Organization organization = getQuery.execute(request.getId());
        organization.setName(request.getName());
        organization.setDescription(request.getDescription());
        verifyQuery.execute(organization);
        return repository.update(organization);
    }
}
