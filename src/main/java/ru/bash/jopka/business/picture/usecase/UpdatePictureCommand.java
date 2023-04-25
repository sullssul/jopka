package ru.bash.jopka.business.picture.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.picture.model.Picture;
import ru.bash.jopka.business.picture.repository.PictureRepository;
import ru.bash.jopka.controller.picture.dto.UpdatePictureRequest;

@Component
@RequiredArgsConstructor
public class UpdatePictureCommand {
    private final PictureRepository repository;
    private final GetPictureQuery getQuery;

    public Picture execute(UpdatePictureRequest request) {
        Picture picture = getQuery.execute(request.getId());

        picture.setName(request.getName());
        picture.setSize(request.getSize());
        picture.setBase64(request.getBase64());
        picture.setRatingValue(request.getRatingValue());
        picture.setUserId(request.getUserId());
        picture.setNominationId(request.getNominationId());
        picture.setStatusId(request.getStatusId());

        return repository.update(picture);
    }
}
