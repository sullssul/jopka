package ru.bash.jopka.business.organization.repository.jpa;

import org.springframework.stereotype.Component;
import ru.bash.jopka.business.organization.model.Organization;

@Component
public class JpaOrganizationMapper {
    public JpaOrganization toJpa(Organization organization) {
        JpaOrganization jpaOrganization = new JpaOrganization();
        jpaOrganization.setId(organization.getId());
        jpaOrganization.setName(organization.getName());
        jpaOrganization.setDescription(organization.getDescription());
        return jpaOrganization;
    }

    public Organization fromJpa(JpaOrganization jpaOrganization) {
        return Organization.builder()
                .id(jpaOrganization.getId())
                .name(jpaOrganization.getName())
                .description(jpaOrganization.getDescription())
                .build();
    }
}
