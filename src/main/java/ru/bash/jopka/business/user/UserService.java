package ru.bash.jopka.business.user;

import ru.bash.jopka.Controller.dto.RegisterRequest;
import ru.bash.jopka.Controller.dto.UpdateUserRequest;
import ru.bash.jopka.business.user.model.User;

import java.util.Set;

public interface UserService {
    User findUserWithFilter(String filterName, String value);
    User updateUser(UpdateUserRequest request);
    User registerUser(RegisterRequest request);
    User findUser(int id);
    String delete(int id);
    Set<User> findAll();
}
