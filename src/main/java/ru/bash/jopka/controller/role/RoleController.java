package ru.bash.jopka.controller.role;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.bash.jopka.business.role.RoleService;
import ru.bash.jopka.business.role.model.Role;
import ru.bash.jopka.controller.role.dto.CreateRoleRequest;
import ru.bash.jopka.controller.role.dto.UpdateRoleRequest;
import ru.bash.jopka.exception.APIException;

import java.util.Optional;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/role")
@CrossOrigin("${rest.cross.origin}")
public class RoleController {

    private final RoleService service;

    @PostMapping(value = "/create")
    @PreAuthorize("hasRole('ADMIN')")
    public Role create(@RequestBody @Valid CreateRoleRequest request) {
        return service.create(request);
    }

    @PostMapping(value = "/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Role update(@RequestBody @Valid UpdateRoleRequest request) {
        return service.update(request);
    }

    @GetMapping("/{id}")
    public Role findById(@PathVariable int id) {
        return service.find(id)
                .orElseThrow(() ->
                        new APIException(HttpStatus.NOT_FOUND, "Роль c id: " + id + " - не найдена!")
                );
    }

    @GetMapping("/findAll")
    public Set<Role> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> delete(@PathVariable @Positive long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
