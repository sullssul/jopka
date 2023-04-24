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
        return repository.find(id)
                .orElseThrow(() ->
                        new APIException(HttpStatus.NOT_FOUND, "Организация c id: " + id + " - не найдена!")
                );
    }
}
