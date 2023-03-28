package ru.bash.jopka.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bash.jopka.database.model.Picture;

import java.util.Set;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {
    Set<Picture> findPicturesByJpaUser(long userId);
}
