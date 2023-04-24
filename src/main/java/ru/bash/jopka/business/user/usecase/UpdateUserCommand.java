package ru.bash.jopka.business.user.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.user.repository.UserRepository;
import ru.bash.jopka.controller.user.dto.UpdateUserRequest;
import ru.bash.jopka.business.user.model.User;

@Component
@RequiredArgsConstructor
public class UpdateUserCommand {
    private final UserRepository repository;
    private final VerifyUserQuery verifyQuery;
    private final GetUserQuery getQuery;
    public User execute(UpdateUserRequest request){
        User user = getQuery.execute(request.getId());

        user.setCity(request.getCity());
        user.setBirthday(request.getBirthday());
        user.setEmail(request.getEmail());
        user.setAboutMe(request.getAboutMe());
        user.setFatherName(request.getFatherName());
        user.setFirstName(request.getFirstName());
        user.setSecondName(request.getSecondName());
        user.setCountry(request.getCountry());
        user.setOrganizationId(request.getOrganizationId());
        user.setPassword(request.getPassword());
        user.setPhone(request.getPhone());
        user.setRoleId(request.getRoleId());

        verifyQuery.execute(user);

        return repository.update(user);
    }
}
