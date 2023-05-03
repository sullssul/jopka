package ru.bash.jopka.controller.picture.dto;

import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class UpdatePictureRating {
    @Positive
    private long pictureId;
    @Positive
    private int ratingValue;
}
