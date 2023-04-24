package ru.bash.jopka.controller.nomimation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bash.jopka.business.nomination.NominationService;
import ru.bash.jopka.business.nomination.model.Nomination;
import ru.bash.jopka.controller.nomimation.dto.CreateNominationRequest;
import ru.bash.jopka.controller.nomimation.dto.UpdateNominationRequest;
import ru.bash.jopka.exception.APIException;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/nomination")
@CrossOrigin("${rest.cross.origin}")
public class NominationController {
    private final NominationService service;

    @PostMapping(value = "/create")
    public Nomination create(@RequestBody @Valid CreateNominationRequest request) {
        return service.create(request);
    }

    @PostMapping(value = "/update")
    public Nomination update(@RequestBody @Valid UpdateNominationRequest request) {
        return service.update(request);
    }

    @GetMapping("/{id}")
    public Nomination findById(@PathVariable @Positive int id) {
        return service.find(id)
                .orElseThrow(() ->
                        new APIException(HttpStatus.NOT_FOUND, "Номинация c id: " + id + " - не найдена!")
                );
    }

    @GetMapping("/findAll")
    public Set<Nomination> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Positive long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
