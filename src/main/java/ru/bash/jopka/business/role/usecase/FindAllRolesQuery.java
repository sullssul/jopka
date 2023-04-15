package ru.bash.jopka.business.role.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.role.model.Role;
import ru.bash.jopka.business.role.repository.RoleRepository;

import java.util.Set;


@Component
@RequiredArgsConstructor
public class FindAllRolesQuery {

    private final RoleRepository repository;

    public Set<Role> execute() {
        return repository.findAll();
    }
}
