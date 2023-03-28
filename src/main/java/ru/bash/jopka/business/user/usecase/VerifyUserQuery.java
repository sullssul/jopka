package ru.bash.jopka.business.user.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import ru.bash.jopka.business.user.model.User;
import ru.bash.jopka.business.user.repository.UserRepository;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class VerifyUserQuery {
    private final UserRepository userRepository;

    public void execute(User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null && !Objects.equals(user.getId(), existingUser.getId())){
             throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Пользователь c таким email уже существует!");
        }
    }
}
