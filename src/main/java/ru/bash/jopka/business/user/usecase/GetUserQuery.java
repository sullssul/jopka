package ru.bash.jopka.business.user.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.user.model.User;
import ru.bash.jopka.business.user.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class GetUserQuery {
    private final UserRepository userRepository;

    public User execute(long id) {
        User user = userRepository.find(id);
        if (user == null) throw new RuntimeException("user not found");//todo new exception
        return user;
    }
}
