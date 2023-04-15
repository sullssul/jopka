package ru.bash.jopka.business.role;

import ru.bash.jopka.Controller.dto.CreateRoleRequest;
import ru.bash.jopka.Controller.dto.UpdateRoleRequest;
import ru.bash.jopka.business.role.model.Role;

import java.util.Set;

public interface RoleService {
    Role updateRole(UpdateRoleRequest request);
    Role createRole(CreateRoleRequest request);
    Role findRole(int id);
    String delete(int id);
    Set<Role> findAll();
}
