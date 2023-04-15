package ru.bash.jopka.business.organization.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.organization.model.Organization;
import ru.bash.jopka.business.organization.repository.OrganizationRepository;

@Component
@RequiredArgsConstructor
public class FindOrganizationQuery {
    private final OrganizationRepository repository;

    public Organization execute(long id) {
        return repository.find(id);
    }
}
