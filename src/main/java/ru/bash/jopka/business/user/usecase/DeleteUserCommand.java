package ru.bash.jopka.business.user.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.user.model.User;
import ru.bash.jopka.business.user.repository.UserRepository;

@Slf4j
@Component
@RequiredArgsConstructor
public class DeleteUserCommand {
    private final UserRepository repository;
    private final GetUserQuery getUserQuery;

    public void execute(long id) {
        User user = getUserQuery.execute(id);
        repository.delete(id);

        log.debug("User deleted: " + user);
    }
}
