package ru.bash.jopka.business.user.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.user.model.User;
import ru.bash.jopka.business.user.repository.UserRepository;
import ru.bash.jopka.exception.APIException;

@Component
@RequiredArgsConstructor
public class GetUserByEmailQuery {

    private final UserRepository repository;

    public User execute(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() ->
                        new APIException(HttpStatus.NOT_FOUND, "Пользователь c email: " + email + " - не найден!")
                );
    }

}
