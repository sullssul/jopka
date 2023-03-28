package ru.bash.jopka.business.user.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.user.model.User;
import ru.bash.jopka.business.user.repository.UserRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class findAllByEmailQuery {
    private final UserRepository repository;

    public List<User> execute(String email){
        return repository.findAllByEmailLike(email);
    }
}
