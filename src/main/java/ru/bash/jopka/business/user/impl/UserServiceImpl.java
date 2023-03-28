package ru.bash.jopka.business.user.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bash.jopka.Controller.dto.RegisterRequest;
import ru.bash.jopka.business.user.UserService;
import ru.bash.jopka.business.user.model.User;
import ru.bash.jopka.business.user.usecase.CreateUserCommand;
import ru.bash.jopka.business.user.usecase.DeleteUserCommand;
import ru.bash.jopka.business.user.usecase.FindAllUsersQuery;
import ru.bash.jopka.business.user.usecase.FindUserQuery;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final CreateUserCommand createUserCommand;
    private final DeleteUserCommand deleteUserCommand;
    private final FindUserQuery findUserQuery;
    private final FindAllUsersQuery findAllUsersQuery;

    @Override
    public User registerUser(RegisterRequest request) {
        return createUserCommand.execute(request);
    }

    @Override
    public User findUser(int id) {
        return findUserQuery.execute(id);
    }

    @Override
    public String delete(int id) {
        deleteUserCommand.execute(id);
        return "Пользователь успешно удален";
    }

    @Override
    public Set<User> findAll() {
        return findAllUsersQuery.execute();
    }
}
