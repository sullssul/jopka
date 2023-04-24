package ru.bash.jopka.business.user;

import ru.bash.jopka.controller.user.dto.FindUserWithFilterRequest;
import ru.bash.jopka.controller.user.dto.RegisterRequest;
import ru.bash.jopka.controller.user.dto.UpdateUserRequest;
import ru.bash.jopka.business.user.model.User;

import java.util.Set;

public interface UserService {
    Set<User> findWithFilter(FindUserWithFilterRequest request);
    User update(UpdateUserRequest request);
    User register(RegisterRequest request);
    User find(int id);
    String delete(int id);
    Set<User> findAll();
}
