package ru.bash.jopka.business.organization.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bash.jopka.business.organization.OrganizationService;
import ru.bash.jopka.business.organization.model.Organization;
import ru.bash.jopka.business.organization.usecase.*;
import ru.bash.jopka.controller.organization.dto.CreateOrganizationRequest;
import ru.bash.jopka.controller.organization.dto.UpdateOrganizationRequest;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private final CreateOrganizationCommand createCommand;
    private final DeleteOrganizationCommand deleteCommand;
    private final UpdateOrganizationCommand updateCommand;
    private final FindOrganizationQuery findQuery;
    private final FindAllOrganizationsQuery findAllQuery;
    @Override
    public Organization update(UpdateOrganizationRequest request) {
        return updateCommand.execute(request);
    }

    @Override
    public Organization create(CreateOrganizationRequest request) {
        return createCommand.execute(request);
    }

    @Override
    public Optional<Organization> find(long id) {
        return findQuery.execute(id);
    }

    @Override
    public String delete(long id) {
        deleteCommand.execute(id);
        return "Организация успешна удалена";
    }

    @Override
    public Set<Organization> findAll() {
        return findAllQuery.execute();
    }
}
