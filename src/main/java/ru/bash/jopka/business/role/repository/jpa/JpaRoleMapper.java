package ru.bash.jopka.business.role.repository.jpa;

import org.springframework.stereotype.Component;
import ru.bash.jopka.business.role.model.Role;

@Component
public class JpaRoleMapper {
    public JpaRole toJpa(Role role) {
        JpaRole jpaRole = new JpaRole();
        jpaRole.setId(role.getId());
        jpaRole.setName(role.getName());
        return jpaRole;
    }

    public Role fromJpa(JpaRole jpaRole) {
        return Role.builder()
                .id(jpaRole.getId())
                .name(jpaRole.getName())
                .build();
    }
}
