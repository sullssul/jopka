package ru.bash.jopka.business.organization.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.organization.model.Organization;
import ru.bash.jopka.business.organization.repository.OrganizationRepository;
import ru.bash.jopka.exception.APIException;

@Component
@RequiredArgsConstructor
public class GetOrganizationQuery {
    private final OrganizationRepository repository;

    public Organization execute(long id) {
        Organization organization = repository.find(id);
        if (organization == null) throw new APIException(HttpStatus.NOT_FOUND, "Организация не найдена!");
        return organization;
    }
}
