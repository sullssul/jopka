package ru.bash.jopka.business.picture;

import ru.bash.jopka.business.picture.model.Picture;
import ru.bash.jopka.controller.dto.picture.CreatePictureRequest;
import ru.bash.jopka.controller.dto.picture.FindPictureWithFilterRequest;
import ru.bash.jopka.controller.dto.picture.UpdatePictureRequest;

import java.util.Set;

public interface PictureService {

    Picture update(UpdatePictureRequest request);

    Set<Picture> findWithFilter(FindPictureWithFilterRequest request);

    Picture create(CreatePictureRequest request);

    Picture find(int id);

    Set<Picture> findAll();

    String delete(long id);
}
