package ru.bash.jopka.Controller;

import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.bash.jopka.Controller.dto.RegisterRequest;
import ru.bash.jopka.Controller.dto.UpdateUserRequest;
import ru.bash.jopka.business.user.UserService;
import ru.bash.jopka.business.user.model.User;

import java.util.Set;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
@CrossOrigin("${rest.cross.origin}")
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/register")
    public User registerUser(@RequestBody RegisterRequest request) {
        return userService.registerUser(request);
    }

    @PostMapping(value = "/update")
    public User updateUser(@RequestBody UpdateUserRequest request) {
        return userService.updateUser(request);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        User user = userService.findUser(id);
        if (user == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Пользователь не найден!");
        return user;
    }

    @GetMapping("/findAll")
    public Set<User> findAll() {
        return userService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@Positive @PathVariable int id) {
        return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);
    }
}
