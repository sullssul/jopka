package ru.bash.jopka.controller.user;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
        return service.find(id)
                .orElseThrow(() ->
                        new APIException(HttpStatus.NOT_FOUND, "Пользователь c id: " + id + " - не найден!")
                );
    }

    @PostMapping(value = "/find")
    @PreAuthorize("hasRole('ADMIN') or hasRole('JURI')")
    public Set<User> findByFilter(@RequestBody FindUserWithFilterRequest request) {
        return service.findWithFilter(request);
    }

    @GetMapping("/findAll")
    @PreAuthorize("hasRole('ADMIN') or hasRole('JURI')")
    public Set<User> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> delete(@Positive @PathVariable int id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
