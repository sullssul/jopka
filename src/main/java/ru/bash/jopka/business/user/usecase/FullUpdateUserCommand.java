package ru.bash.jopka.business.user.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.user.model.User;
import ru.bash.jopka.business.user.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class FullUpdateUserCommand {

    private final UserRepository repository;


    public User execute(User original, User copy){
            if(original == copy) return original;
            return null;//todo
    }
}
