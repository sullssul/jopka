package ru.bash.jopka.business.picture.usecase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.picture.model.Picture;
import ru.bash.jopka.business.picture.repository.PictureRepository;
import ru.bash.jopka.controller.picture.dto.CreatePictureRequest;
@Slf4j
@Component
@RequiredArgsConstructor
public class CreatePictureCommand {
    private final PictureRepository repository;
    private final VerifyPictureQuery verifyQuery;

    @Transactional
    public Picture execute(CreatePictureRequest request) {
        Picture picture = buildRole(request);
        verifyQuery.execute(picture);

        picture = repository.update(picture);
        log.info("Picture created: " + picture);
        return picture;
    }

    private Picture buildRole(CreatePictureRequest request) {
        return Picture.builder()
                .id(0L)
                .url(request.getUrl())
                .size(request.getSize())
                .ratingValue(request.getRatingValue())
                .userId(request.getUserId())
                .statusId(request.getStatusId())
                .nominationId(request.getNominationId())
                .name(request.getName())
                .build();
    }
}
