package ru.bash.jopka.controller.role;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bash.jopka.business.role.RoleService;
import ru.bash.jopka.business.role.model.Role;
import ru.bash.jopka.controller.role.dto.CreateRoleRequest;
import ru.bash.jopka.controller.role.dto.UpdateRoleRequest;
import ru.bash.jopka.exception.APIException;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/role")
@CrossOrigin("${rest.cross.origin}")
public class RoleController {

    private final RoleService service;

    @PostMapping(value = "/create")
    public Role create(@RequestBody @Valid CreateRoleRequest request) {
        return service.create(request);
    }

    @PostMapping(value = "/update")
    public Role update(@RequestBody @Valid UpdateRoleRequest request) {
        return service.update(request);
    }

    @GetMapping("/{id}")
    public Role findById(@PathVariable int id) {
        Role role = service.find(id);
        if (role == null) throw new APIException(HttpStatus.NOT_FOUND, "Роль не найдена!");
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
