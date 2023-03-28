package ru.bash.jopka.business.user.repository.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.user.model.User;
import ru.bash.jopka.database.model.Picture;
import ru.bash.jopka.database.repository.OrganizationRepository;
import ru.bash.jopka.database.repository.PictureRepository;
import ru.bash.jopka.database.repository.RoleRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JpaUserMapper {
    private final RoleRepository roleRepository;//todo
    private final PictureRepository pictureRepository;

    private final OrganizationRepository organizationRepository;

    public JpaUser toJpa(User user) {
        JpaUser jpaUser = new JpaUser();
        jpaUser.setId(user.getId());
        jpaUser.setEmail(user.getEmail());
        jpaUser.setPhone(user.getPhone());
        jpaUser.setPassword(user.getPassword());
        jpaUser.setBirthday(user.getBirthday());
        jpaUser.setFirstName(user.getFirstName());
        jpaUser.setSecondName(user.getSecondName());
        jpaUser.setFatherName(user.getFatherName());
        jpaUser.setRoles(Set.of(roleRepository.findRoleById(user.getRoleId())));
        jpaUser.setOrganization(Set.of(organizationRepository.find));
        jpaUser.setPictures(pictureRepository.findPicturesByJpaUser(user.getOrganizationId()));
        return jpaUser;
    }

    public User fromJpa(JpaUser jpaUser) {
        return User.builder()
                .id(jpaUser.getId())
                .email(jpaUser.getEmail())
                .phone(jpaUser.getPhone())
                .password(jpaUser.getPassword())
                .birthday(jpaUser.getBirthday())
                .firstName(jpaUser.getFirstName())
                .secondName(jpaUser.getSecondName())
                .fatherName(jpaUser.getFatherName())
                .picturesId(jpaUser.getPictures().stream().map(Picture::getId).collect(Collectors.toSet()))
                .roleId(jpaUser.getRoles().stream().findFirst().orElseThrow(RuntimeException::new).getId())//todo exception
                .build();
    }
}
