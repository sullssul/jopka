package ru.bash.jopka.controller;

import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.bash.jopka.controller.dto.role.CreateRoleRequest;
import ru.bash.jopka.controller.dto.role.UpdateRoleRequest;
import ru.bash.jopka.business.role.RoleService;
import ru.bash.jopka.business.role.model.Role;

import java.util.Set;

@RequestMapping("/role")
@RestController
@RequiredArgsConstructor
@CrossOrigin("${rest.cross.origin}")
public class RoleController {

    private final RoleService service;

    @PostMapping(value = "/create")
    public Role create(@RequestBody CreateRoleRequest request) {
        return service.create(request);
    }

    @PostMapping(value = "/update")
    public Role update(@RequestBody UpdateRoleRequest request) {
        return service.update(request);
    }

    @GetMapping("/{id}")
    public Role findById(@PathVariable int id) {
        Role role = service.find(id);
        if (role == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Роль не найдена!");
        return role;
    }

    @GetMapping("/findAll")
    public Set<Role> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@Positive @PathVariable long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
