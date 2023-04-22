package ru.bash.jopka.business.user.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.user.model.User;
import ru.bash.jopka.business.user.repository.UserRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindUserByEmail {
    private final UserRepository repository;

    public Optional<User> execute(String email){
        return repository.findByEmail(email);
    }
}
