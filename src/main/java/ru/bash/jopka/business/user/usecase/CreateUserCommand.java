package ru.bash.jopka.business.user.usecase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.bash.jopka.controller.user.dto.RegisterRequest;
import ru.bash.jopka.business.user.model.User;
import ru.bash.jopka.business.user.repository.UserRepository;

import java.util.ArrayList;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateUserCommand {
    private final UserRepository repository;
    private final VerifyUserQuery verifyQuery;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User execute(RegisterRequest request) {
        User user = buildUser(request);
        verifyQuery.execute(user);

        user = repository.update(user);
        log.debug("User created: " + user);
        return user;
    }

    private User buildUser(RegisterRequest request) {
        return User.builder()
                .id(0L)
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .phone(request.getPhone())
                .roleId(request.getRoleId())
                .birthday(request.getBirthday())
                .country(request.getCountry())
                .city(request.getCity())
                .aboutMe(request.getAboutMe())
                .firstName(request.getFirstName())
                .fatherName(request.getFatherName())
                .secondName(request.getSecondName())
                .organizationId(request.getOrganizationId())
                .picturesId(new ArrayList<>())
                .supervisorPhoneNumber(request.getSupervisorPhoneNumber())
                .supervisorPosition(request.getSupervisorPosition())
                .supervisorFullName(request.getSupervisorFullName())
                .faculty(request.getFaculty())
                .build();
    }
}
