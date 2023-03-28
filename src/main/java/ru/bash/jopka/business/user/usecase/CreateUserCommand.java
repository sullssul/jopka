package ru.bash.jopka.business.user.usecase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.bash.jopka.Controller.dto.RegisterRequest;
import ru.bash.jopka.business.user.model.User;
import ru.bash.jopka.business.user.repository.UserRepository;

import java.util.ArrayList;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateUserCommand {
    private final UserRepository userRepository;
    private final VerifyUserQuery verifyUserQuery;

    @Transactional
    public User execute(RegisterRequest request) {
        User user = buildUser(request);
        verifyUserQuery.execute(user);

        user = userRepository.update(user);
        log.debug("User created: " + user);
        return user;
    }

    private User buildUser(RegisterRequest request) {
        return User.builder()
                .id(0L)
                .password(request.getPassword())
                .email(request.getEmail())
                .phone(request.getPhone())
                .roleId(request.getRoleId())
                .birthday(request.getBirthday())
                .firstName(request.getFirstName())
                .fatherName(request.getFatherName())
                .secondName(request.getSecondName())
                .organizationId(request.getOrganizationId())
                .picturesId(new ArrayList<>())
                .build();
    }
}
