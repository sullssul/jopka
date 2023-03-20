package ru.bash.jopka.business.user.repository.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.user.model.User;
import ru.bash.jopka.database.model.Picture;
import ru.bash.jopka.database.repository.PictureRepository;
import ru.bash.jopka.database.repository.RoleRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JpaUserMapper {

    private final RoleRepository roleRepository;//todo
    private final PictureRepository pictureRepository;
    public JpaUser toJpa(User user) {

        return JpaUser.builder()
                .id(user.getId())
                .email(user.getEmail())
                .phone(user.getPhone())
                .password(user.getPassword())
                .birthday(user.getBirthday())
                .firstName(user.getFirstName())
                .secondName(user.getSecondName())
                .fatherName(user.getFatherName())
                .roles(Set.of(roleRepository.findRoleById(user.getId())))
                .pictures(pictureRepository.findPicturesByUserId(user.getId()))
                .build();
    }

    public User fromJpa(JpaUser jpaUser) {
        return  User.builder()
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
