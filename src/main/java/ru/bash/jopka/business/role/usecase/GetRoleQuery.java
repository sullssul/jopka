package ru.bash.jopka.business.role.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.role.model.Role;
import ru.bash.jopka.business.role.repository.RoleRepository;
import ru.bash.jopka.exception.APIException;

@Component
@RequiredArgsConstructor
public class GetRoleQuery {
    private final RoleRepository repository;

    public Role execute(long id) {
        return repository.find(id)
                .orElseThrow(() ->
                        new APIException(HttpStatus.NOT_FOUND, "Роль c id: " + id + " - не найдена!")
                );
    }
}
