package ru.bash.jopka.business.picture.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import ru.bash.jopka.business.picture.model.Picture;
import ru.bash.jopka.business.picture.repository.PictureRepository;

@Component
@RequiredArgsConstructor
public class GetPictureQuery {
    private final PictureRepository repository;
    public Picture execute(long id) {
        Picture picture = repository.find(id);
        if (picture == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Работа не найдена!");
        return picture;
    }
}
