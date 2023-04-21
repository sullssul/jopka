package ru.bash.jopka.business.picture.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.picture.model.Picture;
import ru.bash.jopka.business.picture.repository.PictureRepository;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class FindAllPicturesQuery {
    private final PictureRepository repository;

    public Set<Picture> execute() {
        return repository.findAll();
    }
}
