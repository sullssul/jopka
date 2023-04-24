package ru.bash.jopka.controller.user;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bash.jopka.business.user.UserService;
import ru.bash.jopka.business.user.model.User;
import ru.bash.jopka.controller.user.dto.FindUserWithFilterRequest;
import ru.bash.jopka.controller.user.dto.RegisterRequest;
import ru.bash.jopka.controller.user.dto.UpdateUserRequest;
import ru.bash.jopka.exception.APIException;

import java.util.Set;

@RequestMapping("/api/user")
@RestController
@RequiredArgsConstructor
@CrossOrigin("${rest.cross.origin}")
public class UserController {
    private final UserService service;

    @PostMapping(value = "/register")
    public User register(@RequestBody @Valid RegisterRequest request) {
        return service.register(request);
    }

    @PostMapping(value = "/update")
    public User update(@RequestBody @Valid UpdateUserRequest request) {
        return service.update(request);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable int id) {
        User user = service.find(id);
        if (user == null) throw new APIException(HttpStatus.NOT_FOUND, "Пользователь не найден!");
        return user;
    }

    @PostMapping(value = "/find")
    public Set<User> findByFilter(@RequestBody FindUserWithFilterRequest request) {
        return service.findWithFilter(request);
    }

    @GetMapping("/findAll")
    public Set<User> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@Positive @PathVariable int id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}