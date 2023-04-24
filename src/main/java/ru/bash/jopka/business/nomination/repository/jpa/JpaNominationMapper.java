package ru.bash.jopka.business.nomination.repository.jpa;

import org.springframework.stereotype.Component;
import ru.bash.jopka.business.nomination.model.Nomination;

@Component
public class JpaNominationMapper {
    public Nomination fromJpa(JpaNomination jpaNomination) {
        return Nomination.builder()
                .id(jpaNomination.getId())
                .name(jpaNomination.getName())
                .build();
    }

    public JpaNomination toJpa(Nomination nomination) {
        JpaNomination jpaNomination = new JpaNomination();
        jpaNomination.setId(nomination.getId());
        jpaNomination.setName(nomination.getName());
        return jpaNomination;
    }
}
