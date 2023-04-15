package ru.bash.jopka.business.role.repository.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.role.model.Role;
import ru.bash.jopka.business.role.repository.RoleRepository;
import ru.bash.jopka.business.user.model.User;
import ru.bash.jopka.business.user.repository.jpa.JpaUser;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RoleRepositoryImpl implements RoleRepository {

    private final JpaRoleRepository repository;
    private final JpaRoleMapper mapper;

    @Override
    public Role find(long id) {
        return repository.findById(id)
                .map(mapper::fromJpa)
                .orElse(null);
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
    public Role findByName(String name) {
        return repository.findByName(name)
                .map(mapper::fromJpa)
                .orElse(null);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
