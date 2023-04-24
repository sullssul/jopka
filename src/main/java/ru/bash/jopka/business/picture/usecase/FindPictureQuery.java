package ru.bash.jopka.business.picture.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.picture.model.Picture;
import ru.bash.jopka.business.picture.repository.PictureRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindPictureQuery {
    private final PictureRepository repository;

    public Optional<Picture> execute(long id) {
        return repository.find(id);
    }
}
