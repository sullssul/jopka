package ru.bash.jopka.business.status.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Status {
    private Long id;
    private String name;
}
