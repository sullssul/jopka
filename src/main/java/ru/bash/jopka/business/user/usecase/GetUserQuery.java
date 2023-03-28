package ru.bash.jopka.business.user.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import ru.bash.jopka.business.user.model.User;
import ru.bash.jopka.business.user.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class GetUserQuery {
    private final UserRepository userRepository;

    public User execute(long id) {
        User user = userRepository.find(id);
        if (user == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Пользователь не найден!");
        return user;
    }
}
