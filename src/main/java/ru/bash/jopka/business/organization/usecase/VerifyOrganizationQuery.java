package ru.bash.jopka.business.organization.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.organization.model.Organization;
import ru.bash.jopka.business.organization.repository.OrganizationRepository;
import ru.bash.jopka.exception.APIException;

@Component
@RequiredArgsConstructor
public class VerifyOrganizationQuery {
    private final OrganizationRepository repository;

    public void execute(Organization organization) {
        Organization existingOrganization = repository.findByName(organization.getName());
        if (existingOrganization != null) {
            throw new APIException(HttpStatus.BAD_REQUEST, "Организация c таким названием уже существует!");
        }
    }
}
