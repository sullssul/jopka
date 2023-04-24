package ru.bash.jopka.business.role.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.role.model.Role;
import ru.bash.jopka.business.role.repository.RoleRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindRoleQuery {
    private final RoleRepository repository;

    public Optional<Role> execute(long id) {
        return repository.find(id);
    }
}
