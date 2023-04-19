package ru.bash.jopka.business.user.repository.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.organization.OrganizationService;
import ru.bash.jopka.business.organization.repository.jpa.JpaOrganization;
import ru.bash.jopka.business.organization.repository.jpa.JpaOrganizationMapper;
import ru.bash.jopka.business.role.RoleService;
import ru.bash.jopka.business.role.repository.jpa.JpaRole;
import ru.bash.jopka.business.role.repository.jpa.JpaRoleMapper;
import ru.bash.jopka.business.user.model.User;
import ru.bash.jopka.database.model.Picture;
import ru.bash.jopka.database.repository.PictureRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JpaUserMapper {
    private final RoleService roleService;
    private final JpaRoleMapper jpaRoleMapper;
    private final OrganizationService organizationService;
    private final JpaOrganizationMapper jpaOrganizationMapper;
    private final PictureRepository pictureRepository;

    public JpaUser toJpa(User user) {
        JpaUser jpaUser = new JpaUser();
        jpaUser.setId(user.getId());
        jpaUser.setEmail(user.getEmail());
        jpaUser.setPhone(user.getPhone());
        jpaUser.setPassword(user.getPassword());
        jpaUser.setCity(user.getCity());
        jpaUser.setCountry(user.getCountry());
        jpaUser.setAboutMe(user.getAboutMe());
        jpaUser.setFirstName(user.getFirstName());
        jpaUser.setSecondName(user.getSecondName());
        jpaUser.setFatherName(user.getFatherName());
        jpaUser.setRoles(getRole(user.getRoleId()));
        jpaUser.setBirthday(user.getBirthday());
        jpaUser.setOrganization(getOrganization(user.getOrganizationId()));
        jpaUser.setPictures(getPictures(user.getPicturesId()));
        return jpaUser;
    }


    public User fromJpa(JpaUser jpaUser) {
        return User.builder()
                .id(jpaUser.getId())
                .email(jpaUser.getEmail())
                .phone(jpaUser.getPhone())
                .password(jpaUser.getPassword())
                .city(jpaUser.getCity())
                .country(jpaUser.getCountry())
                .aboutMe(jpaUser.getAboutMe())
                .birthday(jpaUser.getBirthday())
                .firstName(jpaUser.getFirstName())
                .secondName(jpaUser.getSecondName())
                .fatherName(jpaUser.getFatherName())
                .picturesId(jpaUser.getPictures().stream().map(Picture::getId).collect(Collectors.toList()))
                .roleId(jpaUser.getRoles().stream().findFirst().orElseThrow(RuntimeException::new).getId())//todo exception
                .organizationId(jpaUser.getOrganization().getId())
                .build();
    }

    private Set<JpaRole> getRole(long roleId) {
        return Set.of(jpaRoleMapper.toJpa(roleService.find(roleId)));
    }

    private JpaOrganization getOrganization(long organizationId) {
        return jpaOrganizationMapper.toJpa(organizationService.find(organizationId));
    }
    private Set<Picture> getPictures(List<Long> picturesIds) {
        return picturesIds
                .stream()
                .map(id -> pictureRepository.findById(id).get())//todo
                .collect(Collectors.toSet());
    }
}
