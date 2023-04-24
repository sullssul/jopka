package ru.bash.jopka.business.role.usecase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.bash.jopka.controller.role.dto.CreateRoleRequest;
import ru.bash.jopka.business.role.model.Role;
import ru.bash.jopka.business.role.repository.RoleRepository;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateRoleCommand {
    private final RoleRepository repository;
    private final VerifyRoleQuery verifyQuery;

    @Transactional
    public Role execute(CreateRoleRequest request) {
        Role role = buildRole(request);
        verifyQuery.execute(role);

        role = repository.update(role);
        log.info("Role created: " + role);
        return role;
    }

    private Role buildRole(CreateRoleRequest request) {
        return Role.builder()
                .name(request.getName())
                .build();
    }
}
