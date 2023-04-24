package ru.bash.jopka.business.role.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bash.jopka.controller.role.dto.CreateRoleRequest;
import ru.bash.jopka.controller.role.dto.UpdateRoleRequest;
import ru.bash.jopka.business.role.RoleService;
import ru.bash.jopka.business.role.model.Role;
import ru.bash.jopka.business.role.usecase.*;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final CreateRoleCommand createCommand;
    private final DeleteRoleCommand deleteCommand;
    private final UpdateRoleCommand updateCommand;
    private final FindRoleQuery findQuery;
    private final FindAllRolesQuery findAllQuery;
    @Override
    public Role update(UpdateRoleRequest request) {
        return updateCommand.execute(request);
    }

    @Override
    public Role create(CreateRoleRequest request) {
        return createCommand.execute(request);
    }

    @Override
    public Role find(long id) {
        return findQuery.execute(id);
    }

    @Override
    public String delete(long id) {
        deleteCommand.execute(id);
        return "Роль успешна удалена";
    }

    @Override
    public Set<Role> findAll() {
        return findAllQuery.execute();
    }
}
