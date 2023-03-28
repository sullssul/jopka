package ru.bash.jopka.business.user;

import ru.bash.jopka.Controller.dto.RegisterRequest;
import ru.bash.jopka.business.user.model.User;

public interface UserService {
    User registerUser(RegisterRequest request);
    User findUser(int id);
    String delete(int id);
}
