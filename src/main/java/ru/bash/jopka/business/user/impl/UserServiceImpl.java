package ru.bash.jopka.business.user.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bash.jopka.business.picture.usecase.FindPictureWithFilterQuery;
import ru.bash.jopka.business.user.usecase.*;
import ru.bash.jopka.controller.dto.user.FindUserWithFilterRequest;
import ru.bash.jopka.controller.dto.user.RegisterRequest;
import ru.bash.jopka.controller.dto.user.UpdateUserRequest;
import ru.bash.jopka.business.user.UserService;
import ru.bash.jopka.business.user.model.User;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final CreateUserCommand createUserCommand;
    private final DeleteUserCommand deleteUserCommand;
    private final UpdateUserCommand updateCommand;
    private final FindUserQuery findUserQuery;
    private final FindAllUsersQuery findAllUsersQuery;
    private final FindUserWithFilterQuery findWithFilterQuery;

    @Override
    public Set<User> findWithFilter(FindUserWithFilterRequest request) {
        return findWithFilterQuery.execute(request);
    }

    @Override
    public User update(UpdateUserRequest request) {
        return updateCommand.execute(request);
    }

    @Override
    public User register(RegisterRequest request) {
        return createUserCommand.execute(request);
    }

    @Override
    public User find(int id) {
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
