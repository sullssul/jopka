package ru.bash.jopka.controller.picture.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class UpdatePictureRequest {
    @Positive
    private long id;
    @NotEmpty
    private String name;
    private String size;
    private String url;
    private int ratingValue;
    @Positive
    private long userId;
    @Positive
    private long statusId;
    @Positive
    private long nominationId;
}
