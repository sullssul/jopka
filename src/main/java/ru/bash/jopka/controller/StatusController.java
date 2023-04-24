package ru.bash.jopka.controller;

import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bash.jopka.business.status.StatusService;
import ru.bash.jopka.business.status.model.Status;
import ru.bash.jopka.controller.dto.status.CreateStatusRequest;
import ru.bash.jopka.controller.dto.status.UpdateStatusRequest;
import ru.bash.jopka.exception.APIException;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/status")
@CrossOrigin("${rest.cross.origin}")
public class StatusController {
    private final StatusService service;

    @PostMapping(value = "/create")
    public Status create(@RequestBody CreateStatusRequest request) {
        return service.create(request);
    }

    @PostMapping(value = "/update")
    public Status update(@RequestBody UpdateStatusRequest request) {
        return service.update(request);
    }

    @GetMapping("/{id}")
    public Status findById(@PathVariable int id) {
        Status status = service.find(id);
        if (status == null) throw new APIException(HttpStatus.NOT_FOUND, "Статус не найден!");
        return status;
    }

    @GetMapping("/findAll")
    public Set<Status> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@Positive @PathVariable long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
