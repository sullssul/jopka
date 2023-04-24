package ru.bash.jopka.business.picture.repository;

import ru.bash.jopka.business.picture.model.Picture;

import java.util.Optional;
import java.util.Set;

public interface PictureRepository {
    Optional<Picture> find(long id);
    Picture update(Picture picture);
    Set<Picture> findByCriteriaQuery(String name, long userId, long statusId, long nominationId, int ratingValue);
    Set<Picture> findAll();
    void delete(long id);
}
