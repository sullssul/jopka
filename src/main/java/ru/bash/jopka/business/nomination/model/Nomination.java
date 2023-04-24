package ru.bash.jopka.business.nomination.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Nomination {
    private Long id;
    private String name;
}
