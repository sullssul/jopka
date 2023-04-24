package ru.bash.jopka.business.role.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.role.model.Role;
import ru.bash.jopka.business.role.repository.RoleRepository;
import ru.bash.jopka.business.role.repository.jpa.JpaRole;
import ru.bash.jopka.business.role.repository.jpa.JpaRoleMapper;
import ru.bash.jopka.business.role.repository.jpa.JpaRoleRepository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RoleRepositoryImpl implements RoleRepository {

    private final JpaRoleRepository repository;
    private final JpaRoleMapper mapper;

    @Override
    public Optional<Role> find(long id) {
        return repository.findById(id)
                .map(mapper::fromJpa);
    }

    @Override
    public Role update(Role role) {
        JpaRole entity = repository.save(mapper.toJpa(role));
        return mapper.fromJpa(entity);
    }

    @Override
    public Set<Role> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::fromJpa)
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<Role> findByName(String name) {
        return repository.findByName(name)
                .map(mapper::fromJpa);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
