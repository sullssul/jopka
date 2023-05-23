package ru.bash.jopka.business.user.repository.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.organization.repository.jpa.JpaOrganization;
import ru.bash.jopka.business.picture.repository.jpa.JpaPicture;
import ru.bash.jopka.business.role.repository.jpa.JpaRole;
import ru.bash.jopka.business.user.model.User;
import ru.bash.jopka.exception.APIException;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JpaUserMapper {

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
        jpaUser.setFaculty(user.getFaculty());
        jpaUser.setSupervisorPosition(user.getSupervisorPosition());
        jpaUser.setSupervisorFullName(user.getSupervisorFullName());
        jpaUser.setSupervisorPhoneNumber(user.getSupervisorPhoneNumber());
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
                .picturesId(jpaUser.getPictures().stream().map(JpaPicture::getId).collect(Collectors.toList()))
                .roleId(jpaUser.getRoles().stream().findFirst().orElseThrow(() -> new APIException(HttpStatus.BAD_REQUEST, "Не удалось найти роль")).getId())
                .organizationId(jpaUser.getOrganization().getId())
                .faculty(jpaUser.getFaculty())
                .supervisorFullName(jpaUser.getSupervisorFullName())
                .supervisorPosition(jpaUser.getSupervisorPosition())
                .supervisorPhoneNumber(jpaUser.getSupervisorPhoneNumber())
                .build();
    }

    private Set<JpaRole> getRole(long roleId) {
        JpaRole role = new JpaRole();
        role.setId(roleId);
        return Set.of(role);
    }

    private JpaOrganization getOrganization(long organizationId) {
        JpaOrganization organization = new JpaOrganization();
        organization.setId(organizationId);
        return organization;
    }

    private Set<JpaPicture> getPictures(List<Long> picturesIds) {
        return picturesIds
                .stream()
                .map(this::getJpaPicture)
                .collect(Collectors.toSet());
    }

    private JpaPicture getJpaPicture(long id) {
        JpaPicture jpaPicture = new JpaPicture();
        jpaPicture.setId(id);
        return jpaPicture;
    }
}
