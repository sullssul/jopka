package ru.bash.jopka.business.role.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.controller.role.dto.UpdateRoleRequest;
import ru.bash.jopka.business.role.model.Role;
import ru.bash.jopka.business.role.repository.RoleRepository;

@Component
@RequiredArgsConstructor
public class UpdateRoleCommand {
    private final RoleRepository repository;
    private final GetRoleQuery getRoleQuery;
    private final VerifyRoleQuery verifyQuery;

    public Role execute(UpdateRoleRequest request) {
        Role role = getRoleQuery.execute(request.getId());
        role.setName(request.getName());
        verifyQuery.execute(role);
        return repository.update(role);
    }
}
