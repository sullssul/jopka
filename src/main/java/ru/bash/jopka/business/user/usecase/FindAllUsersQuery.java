package ru.bash.jopka.business.user.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.user.model.User;
import ru.bash.jopka.business.user.repository.UserRepository;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class FindAllUsersQuery {

    private final UserRepository userRepository;

    public Set<User> execute() {
        return userRepository.findAll();
    }
}
