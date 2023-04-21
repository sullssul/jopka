package ru.bash.jopka.controller.dto.picture;

import lombok.Data;

@Data
public class CreatePictureRequest {
    private String name;
    private String size;
    private String url;
    private int ratingValue;
    private long userId;
    private long statusId;
    private long nominationId;
}
