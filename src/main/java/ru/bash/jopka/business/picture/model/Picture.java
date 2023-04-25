package ru.bash.jopka.business.picture.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Picture {
    private Long id;
    private String name;
    private String size;
    private String base64;
    private int ratingValue;
    private long userId;
    private long statusId;
    private long nominationId;
}
