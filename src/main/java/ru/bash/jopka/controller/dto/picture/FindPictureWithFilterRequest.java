package ru.bash.jopka.controller.dto.picture;

import lombok.Data;

@Data
public class FindPictureWithFilterRequest {
    private String name;
    private int ratingValue = 0;
    private long userId = 0;
    private long statusId = 0;
    private long nominationId = 0;
}
