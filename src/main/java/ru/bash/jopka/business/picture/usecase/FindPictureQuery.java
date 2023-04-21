package ru.bash.jopka.business.picture.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.picture.model.Picture;
import ru.bash.jopka.business.picture.repository.PictureRepository;

@Component
@RequiredArgsConstructor
public class FindPictureQuery {
    private final PictureRepository repository;

    public Picture execute(long id) {
        return repository.find(id);
    }
}
