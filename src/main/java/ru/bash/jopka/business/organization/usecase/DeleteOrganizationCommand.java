package ru.bash.jopka.business.organization.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.organization.repository.OrganizationRepository;
@Component
@RequiredArgsConstructor
public class DeleteOrganizationCommand {
    private final OrganizationRepository repository;
    private final GetOrganizationQuery getQuery;

    public void execute(long id) {
        getQuery.execute(id);
        repository.delete(id);
    }
}
