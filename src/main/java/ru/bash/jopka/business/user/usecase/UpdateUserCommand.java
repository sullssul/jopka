package ru.bash.jopka.business.user.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.controller.dto.user.UpdateUserRequest;
import ru.bash.jopka.business.user.model.User;

@Component
@RequiredArgsConstructor
public class UpdateUserCommand {
    private final FullUpdateUserCommand fullUpdateUserCommand;

    public User execute(UpdateUserRequest request){
        return null; //todo
    }
}
