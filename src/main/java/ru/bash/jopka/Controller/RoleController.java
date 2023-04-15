package ru.bash.jopka.Controller;

import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.bash.jopka.Controller.dto.CreateRoleRequest;
import ru.bash.jopka.Controller.dto.UpdateRoleRequest;
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
    public Role createRole(@RequestBody CreateRoleRequest request) {
        return service.createRole(request);
    }

    @PostMapping(value = "/update")
    public Role updateRole(@RequestBody UpdateRoleRequest request) {
        return service.updateRole(request);
    }

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable int id) {
        Role role = service.findRole(id);
        if (role == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Роль не найдена!");
        return role;
    }

    @GetMapping("/findAll")
    public Set<Role> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@Positive @PathVariable int id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
