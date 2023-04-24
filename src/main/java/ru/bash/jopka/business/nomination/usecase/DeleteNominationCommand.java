package ru.bash.jopka.business.nomination.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.nomination.repository.NominationRepository;

@Component
@RequiredArgsConstructor
public class DeleteNominationCommand {
    private final NominationRepository repository;
    private final GetNominationQuery getQuery;

    public void execute(long id) {
        getQuery.execute(id);
        repository.delete(id);
    }
}
