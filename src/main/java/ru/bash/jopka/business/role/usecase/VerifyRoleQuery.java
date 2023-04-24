package ru.bash.jopka.business.role.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.role.model.Role;
import ru.bash.jopka.business.role.repository.RoleRepository;
import ru.bash.jopka.exception.APIException;

import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VerifyRoleQuery {
    private final RoleRepository repository;

    public void execute(Role role) {
        Optional<Role> existingRole = repository.findByName(role.getName());
        if (existingRole.isPresent() && !Objects.equals(existingRole.get().getId(), role.getId())) {
            throw new APIException(HttpStatus.BAD_REQUEST, "Роль c таким названием уже существует!");
        }
    }
}
