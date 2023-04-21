package ru.bash.jopka.business.picture.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPictureRepository extends JpaRepository<JpaPicture, Long> {

}
