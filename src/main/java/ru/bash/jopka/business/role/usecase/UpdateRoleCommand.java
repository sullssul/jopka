package ru.bash.jopka.business.role.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.controller.dto.role.UpdateRoleRequest;
import ru.bash.jopka.business.role.model.Role;
import ru.bash.jopka.business.role.repository.RoleRepository;

@Component
@RequiredArgsConstructor
public class UpdateRoleCommand {
    private final RoleRepository repository;
    private final GetRoleQuery getRoleQuery;

    public Role execute(UpdateRoleRequest request) {
        Role role = getRoleQuery.execute(request.getId());
        role.setName(request.getName());
        return repository.update(role);
    }
}
