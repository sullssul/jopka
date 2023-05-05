package ru.bash.jopka.controller.status;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.bash.jopka.business.status.StatusService;
import ru.bash.jopka.business.status.model.Status;
import ru.bash.jopka.controller.status.dto.CreateStatusRequest;
import ru.bash.jopka.controller.status.dto.UpdateStatusRequest;
import ru.bash.jopka.exception.APIException;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/status")
public class StatusController {
    private final StatusService service;

    @PostMapping(value = "/create")
    @PreAuthorize("hasRole('ADMIN')")
    public Status create(@RequestBody @Valid CreateStatusRequest request) {
        return service.create(request);
    }

    @PostMapping(value = "/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Status update(@RequestBody @Valid UpdateStatusRequest request) {
        return service.update(request);
    }

    @GetMapping("/{id}")
    public Status findById(@PathVariable int id) {
        return service.find(id)
                .orElseThrow(() ->
                        new APIException(HttpStatus.NOT_FOUND, "Статус c id: " + id + " - не найден!")
                );
    }

    @GetMapping("/findAll")
    public Set<Status> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> delete(@Positive @PathVariable long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
