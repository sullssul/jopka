package ru.bash.jopka.business.role.repository;

import ru.bash.jopka.business.role.model.Role;

import java.util.Set;

public interface RoleRepository {
    Role find(long id);
    Role update(Role role);
    Role findByName(String name);
    Set<Role> findAll();
    void delete(long id);
}
