package ru.bash.jopka.business.picture.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.picture.model.Picture;
import ru.bash.jopka.business.picture.repository.PictureRepository;
import ru.bash.jopka.controller.picture.dto.UpdatePictureRating;

@Component
@RequiredArgsConstructor
public class UpdatePictureRatingCommand {
    private final PictureRepository repository;
    private final GetPictureQuery getQuery;

    public Picture execute(UpdatePictureRating request) {
        Picture picture = getQuery.execute(request.getPictureId());
        picture.setRatingValue(request.getRatingValue());
        return repository.update(picture);
    }
}
