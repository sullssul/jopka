package ru.bash.jopka.business.picture;

import ru.bash.jopka.business.picture.model.Picture;
import ru.bash.jopka.controller.picture.dto.CreatePictureRequest;
import ru.bash.jopka.controller.picture.dto.FindPictureWithFilterRequest;
import ru.bash.jopka.controller.picture.dto.UpdatePictureRequest;

import java.util.Optional;
import java.util.Set;

public interface PictureService {

    Picture update(UpdatePictureRequest request);

    Set<Picture> findWithFilter(FindPictureWithFilterRequest request);

    Picture create(CreatePictureRequest request);

    Optional<Picture> find(int id);

    Set<Picture> findAll();

    String delete(long id);
}
