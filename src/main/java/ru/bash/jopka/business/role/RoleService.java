package ru.bash.jopka.business.role;

import ru.bash.jopka.controller.role.dto.CreateRoleRequest;
import ru.bash.jopka.controller.role.dto.UpdateRoleRequest;
import ru.bash.jopka.business.role.model.Role;

import java.util.Set;

public interface RoleService {
    Role update(UpdateRoleRequest request);
    Role create(CreateRoleRequest request);
    Role find(long id);
    String delete(long id);
    Set<Role> findAll();
}
