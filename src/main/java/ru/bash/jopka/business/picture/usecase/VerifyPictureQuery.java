package ru.bash.jopka.business.picture.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.picture.model.Picture;
import ru.bash.jopka.business.picture.repository.PictureRepository;
@Component
@RequiredArgsConstructor
public class VerifyPictureQuery {
    private final PictureRepository repository;
    public void execute(Picture picture) {
        //todo спросить что может быть уникальным, например имя
    }
}
