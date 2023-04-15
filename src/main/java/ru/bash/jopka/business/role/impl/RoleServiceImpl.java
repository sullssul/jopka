package ru.bash.jopka.business.role.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bash.jopka.Controller.dto.CreateRoleRequest;
import ru.bash.jopka.Controller.dto.UpdateRoleRequest;
import ru.bash.jopka.business.role.RoleService;
import ru.bash.jopka.business.role.model.Role;
import ru.bash.jopka.business.role.usecase.*;
import ru.bash.jopka.business.user.usecase.CreateUserCommand;
import ru.bash.jopka.business.user.usecase.DeleteUserCommand;
import ru.bash.jopka.business.user.usecase.FindAllUsersQuery;
import ru.bash.jopka.business.user.usecase.FindUserQuery;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final CreateRoleCommand createRoleCommand;
    private final DeleteRoleCommand deleteRoleCommand;
    private final UpdateRoleCommand updateRoleCommand;
    private final FindRoleQuery findRoleQuery;
    private final FindAllRolesQuery findAllRolesQuery;
    @Override
    public Role updateRole(UpdateRoleRequest request) {
        return updateRoleCommand.execute(request);
    }

    @Override
    public Role createRole(CreateRoleRequest request) {
        return createRoleCommand.execute(request);
    }

    @Override
    public Role findRole(int id) {
        return findRoleQuery.execute(id);
    }

    @Override
    public String delete(int id) {
        deleteRoleCommand.execute(id);
        return "Роль успешна удалена";
    }

    @Override
    public Set<Role> findAll() {
        return findAllRolesQuery.execute();
    }
}
