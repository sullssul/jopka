package ru.bash.jopka.business.status.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.status.repository.StatusRepository;

@Component
@RequiredArgsConstructor
public class DeleteStatusCommand {

    private final StatusRepository repository;
    private final GetStatusQuery getQuery;

    public void execute(long id) {
        getQuery.execute(id);
        repository.delete(id);
    }
}
