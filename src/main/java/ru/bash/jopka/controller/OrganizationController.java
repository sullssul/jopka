package ru.bash.jopka.controller;

import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.bash.jopka.business.organization.OrganizationService;
import ru.bash.jopka.business.organization.model.Organization;
import ru.bash.jopka.controller.dto.Organization.CreateOrganizationRequest;
import ru.bash.jopka.controller.dto.Organization.UpdateOrganizationRequest;

import java.util.Set;
@RequestMapping("/organization")
@RestController
@RequiredArgsConstructor
@CrossOrigin("${rest.cross.origin}")
public class OrganizationController {

    private final OrganizationService service;

    @PostMapping(value = "/create")
    public Organization create(@RequestBody CreateOrganizationRequest request) {
        return service.create(request);
    }

    @PostMapping(value = "/update")
    public Organization update(@RequestBody UpdateOrganizationRequest request) {
        return service.update(request);
    }

    @GetMapping("/{id}")
    public Organization getOrganizationById(@PathVariable int id) {
        Organization organization = service.find(id);
        if (organization == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Организация не найдена!");
        return organization;
    }

    @GetMapping("/findAll")
    public Set<Organization> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@Positive @PathVariable long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
