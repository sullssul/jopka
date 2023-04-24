package ru.bash.jopka.business.picture.repository.jpa;

import org.springframework.stereotype.Component;
import ru.bash.jopka.business.picture.model.Picture;
import ru.bash.jopka.business.user.repository.jpa.JpaUser;
import ru.bash.jopka.business.nomination.repository.jpa.Nomination;
import ru.bash.jopka.business.status.repository.jpa.JpaStatus;

@Component
public class JpaPictureMapper {
    public Picture fromJpa(JpaPicture jpaPicture) {
        return Picture.builder()
                .id(jpaPicture.getId())
                .name(jpaPicture.getName())
                .url(jpaPicture.getUrl())
                .nominationId(jpaPicture.getNomination().getId())
                .ratingValue(jpaPicture.getRatingValue())
                .size(jpaPicture.getSize())
                .statusId(jpaPicture.getStatus().getId())
                .userId(jpaPicture.getJpaUser().getId())
                .build();
    }

    public JpaPicture toJpa(Picture picture) {
        JpaPicture jpaPicture = new JpaPicture();
        jpaPicture.setJpaUser(getJpaUser(picture.getUserId()));
        jpaPicture.setNomination(getJpaNomination(picture.getNominationId()));
        jpaPicture.setStatus(getJpaStatus(picture.getStatusId()));
        jpaPicture.setName(picture.getName());
        jpaPicture.setId(picture.getId());
        jpaPicture.setSize(picture.getSize());
        jpaPicture.setUrl(picture.getUrl());
        jpaPicture.setRatingValue(picture.getRatingValue());
        return jpaPicture;
    }

    private JpaStatus getJpaStatus(long id){
        JpaStatus status = new JpaStatus();
        status.setId(id);
        return status;
    }

    private JpaUser getJpaUser(long id){
        JpaUser user = new JpaUser();
        user.setId(id);
        return user;
    }

    private Nomination getJpaNomination(long id){
        Nomination nomination = new Nomination();
        nomination.setId(id);
        return nomination;
    }
}
