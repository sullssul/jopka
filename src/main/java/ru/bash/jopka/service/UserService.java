package ru.bash.jopka.service;

import ru.bash.jopka.Controller.base.res.BaseRes;
import ru.bash.jopka.Controller.register.dto.RegisterRequest;

public interface UserService {
    BaseRes registerUser(RegisterRequest request);
}
