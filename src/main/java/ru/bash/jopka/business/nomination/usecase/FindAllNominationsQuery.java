package ru.bash.jopka.business.nomination.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.nomination.model.Nomination;
import ru.bash.jopka.business.nomination.repository.NominationRepository;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class FindAllNominationsQuery {
    private final NominationRepository repository;

    public Set<Nomination> execute() {
        return repository.findAll();
    }
}
