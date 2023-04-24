package ru.bash.jopka.business.organization.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.organization.model.Organization;
import ru.bash.jopka.business.organization.repository.OrganizationRepository;
import ru.bash.jopka.business.organization.repository.jpa.JpaOrganization;
import ru.bash.jopka.business.organization.repository.jpa.JpaOrganizationMapper;
import ru.bash.jopka.business.organization.repository.jpa.JpaOrganizationRepository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrganizationRepositoryImpl implements OrganizationRepository {
    private final JpaOrganizationRepository repository;
    private final JpaOrganizationMapper mapper;

    @Override
    public Optional<Organization> find(long id) {
        return repository.findById(id)
                .map(mapper::fromJpa);
    }

    @Override
    public Organization update(Organization organization) {
        JpaOrganization entity = repository.save(mapper.toJpa(organization));
        return mapper.fromJpa(entity);
    }

    @Override
    public Set<Organization> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::fromJpa)
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<Organization> findByName(String name) {
        return repository.findByName(name)
                .map(mapper::fromJpa);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
