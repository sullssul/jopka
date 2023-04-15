package ru.bash.jopka.business.organization.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.organization.model.Organization;
import ru.bash.jopka.business.organization.repository.OrganizationRepository;

import java.util.Set;
@Component
@RequiredArgsConstructor
public class FindAllOrganizationsQuery {
    private final OrganizationRepository repository;

    public Set<Organization> execute() {
        return repository.findAll();
    }
}
