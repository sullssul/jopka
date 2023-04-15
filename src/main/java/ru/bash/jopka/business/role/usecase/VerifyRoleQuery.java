package ru.bash.jopka.business.role.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import ru.bash.jopka.business.role.model.Role;
import ru.bash.jopka.business.role.repository.RoleRepository;

@Component
@RequiredArgsConstructor
public class VerifyRoleQuery {
    private final RoleRepository repository;

    public void execute(Role role) {
        Role existingRole = repository.findByName(role.getName());
        if (existingRole != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Роль c таким названием уже существует!");
        }
    }
}
