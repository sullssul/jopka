package ru.bash.jopka.business.nomination.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.nomination.model.Nomination;
import ru.bash.jopka.business.nomination.repository.NominationRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindNominationQuery {
    private final NominationRepository repository;

    public Optional<Nomination> execute(long id) {
        return repository.find(id);
    }
}
