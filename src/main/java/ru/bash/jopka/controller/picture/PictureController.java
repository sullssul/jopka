package ru.bash.jopka.controller.picture;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.bash.jopka.business.picture.PictureService;
import ru.bash.jopka.business.picture.model.Picture;
import ru.bash.jopka.controller.picture.dto.CreatePictureRequest;
import ru.bash.jopka.controller.picture.dto.FindPictureWithFilterRequest;
import ru.bash.jopka.controller.picture.dto.UpdatePictureRating;
import ru.bash.jopka.controller.picture.dto.UpdatePictureRequest;
import ru.bash.jopka.exception.APIException;

import java.util.Set;

@RequestMapping("/api/picture")
@RestController
@RequiredArgsConstructor
public class PictureController {

    private final PictureService service;

    @PostMapping(value = "/create")
    public Picture create(@RequestBody @Valid CreatePictureRequest request) {
        return service.create(request);
    }

    @PostMapping(value = "/update")
    public Picture update(@RequestBody @Valid UpdatePictureRequest request) {
        return service.update(request);
    }

    @PostMapping(value = "/rating/update/")
    public Picture updateRatingValue(@RequestBody @Valid UpdatePictureRating request) {
        return service.updateRatingValue(request);
    }

    @PostMapping(value = "/find")
    public Set<Picture> findByFilter(@RequestBody FindPictureWithFilterRequest request) {
        return service.findWithFilter(request);
    }

    @GetMapping("/{id}")
    public Picture findById(@PathVariable @Positive int id) {
        return service.find(id)
                .orElseThrow(() ->
                        new APIException(HttpStatus.NOT_FOUND, "Работа c id: " + id + " - не найдена!")
                );
    }

    @GetMapping("/findAll")
    public Set<Picture> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> delete(@Positive @PathVariable long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
