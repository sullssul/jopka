package ru.bash.jopka.business.picture.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.picture.model.Picture;
import ru.bash.jopka.business.picture.repository.PictureRepository;
import ru.bash.jopka.controller.dto.picture.FindPictureWithFilterRequest;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class FindPictureWithFilterQuery {
    private final PictureRepository repository;
    public Set<Picture> execute(FindPictureWithFilterRequest request) {
        return repository.findByCriteriaQuery(
                request.getName(),
                request.getUserId(),
                request.getStatusId(),
                request.getNominationId(),
                request.getRatingValue()
        );
    }

}
