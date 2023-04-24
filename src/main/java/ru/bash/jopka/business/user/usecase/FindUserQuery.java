package ru.bash.jopka.business.user.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.user.model.User;
import ru.bash.jopka.business.user.repository.UserRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindUserQuery {

    private final UserRepository userRepository;

    public Optional<User> execute(long id) {
        return userRepository.find(id);
    }
}
