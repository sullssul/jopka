package ru.bash.jopka.business.organization.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import ru.bash.jopka.business.organization.model.Organization;
import ru.bash.jopka.business.organization.repository.OrganizationRepository;

@Component
@RequiredArgsConstructor
public class VerifyOrganizationQuery {
    private final OrganizationRepository repository;

    public void execute(Organization organization) {
        Organization existingOrganization = repository.findByName(organization.getName());
        if (existingOrganization != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Организация c таким названием уже существует!");
        }
    }
}
