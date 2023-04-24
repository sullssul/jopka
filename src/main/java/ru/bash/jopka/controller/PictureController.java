package ru.bash.jopka.controller;

import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bash.jopka.business.picture.PictureService;
import ru.bash.jopka.business.picture.model.Picture;
import ru.bash.jopka.controller.dto.picture.CreatePictureRequest;
import ru.bash.jopka.controller.dto.picture.FindPictureWithFilterRequest;
import ru.bash.jopka.controller.dto.picture.UpdatePictureRequest;
import ru.bash.jopka.exception.APIException;

import java.util.Set;
@RequestMapping("/api/picture")
@RestController
@RequiredArgsConstructor
@CrossOrigin("${rest.cross.origin}")
public class PictureController {

    private final PictureService service;
    @PostMapping(value = "/create")
    public Picture create(@RequestBody CreatePictureRequest request) {
        return service.create(request);
    }

    @PostMapping(value = "/update")
    public Picture update(@RequestBody UpdatePictureRequest request) {
        return service.update(request);
    }

    @PostMapping(value = "/find")
    public Set<Picture> findByFilter(@RequestBody FindPictureWithFilterRequest request) {
        return service.findWithFilter(request);
    }

    @GetMapping("/{id}")
    public Picture findById(@PathVariable int id) {
        Picture picture = service.find(id);
        if (picture == null) throw new APIException(HttpStatus.NOT_FOUND, "Работа не найдена!");
        return picture;
    }

    @GetMapping("/findAll")
    public Set<Picture> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@Positive @PathVariable long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
