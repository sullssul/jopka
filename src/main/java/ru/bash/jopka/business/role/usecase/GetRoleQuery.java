package ru.bash.jopka.business.role.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import ru.bash.jopka.business.role.model.Role;
import ru.bash.jopka.business.role.repository.RoleRepository;

@Component
@RequiredArgsConstructor
public class GetRoleQuery {
    private final RoleRepository repository;

    public Role execute(long id) {
        Role role = repository.find(id);
        if (role == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Роль не найдена!");
        return role;
    }
}
