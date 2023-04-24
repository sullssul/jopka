package ru.bash.jopka.controller.organization;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.bash.jopka.business.organization.OrganizationService;
import ru.bash.jopka.business.organization.model.Organization;
import ru.bash.jopka.controller.organization.dto.CreateOrganizationRequest;
import ru.bash.jopka.controller.organization.dto.UpdateOrganizationRequest;
import ru.bash.jopka.exception.APIException;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/organization")
@CrossOrigin("${rest.cross.origin}")
public class OrganizationController {
    private final OrganizationService service;

    @PostMapping(value = "/create")
    @PreAuthorize("hasRole('ADMIN')")
    public Organization create(@RequestBody @Valid CreateOrganizationRequest request) {
        return service.create(request);
    }

    @PostMapping(value = "/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Organization update(@RequestBody @Valid UpdateOrganizationRequest request) {
        return service.update(request);
    }

    @GetMapping("/{id}")
    public Organization getOrganizationById(@PathVariable @Positive int id) {
        return service.find(id)
                .orElseThrow(() ->
                        new APIException(HttpStatus.NOT_FOUND, "Организация c id: " + id + " - не найдена!")
                );
    }

    @GetMapping("/findAll")
    public Set<Organization> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> delete(@Positive @PathVariable long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
