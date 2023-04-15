package ru.bash.jopka.business.organization.usecase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.organization.model.Organization;
import ru.bash.jopka.business.organization.repository.OrganizationRepository;
import ru.bash.jopka.controller.dto.Organization.CreateOrganizationRequest;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateOrganizationCommand {
    private final OrganizationRepository repository;
    private final VerifyOrganizationQuery verifyQuery;
    @Transactional
    public Organization execute(CreateOrganizationRequest request) {
        Organization organization = buildOrganization(request);
        verifyQuery.execute(organization);

        organization = repository.update(organization);
        log.info("Organization created: " + organization);
        return organization;
    }

    private Organization buildOrganization(CreateOrganizationRequest request) {
        return Organization.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
    }
}
