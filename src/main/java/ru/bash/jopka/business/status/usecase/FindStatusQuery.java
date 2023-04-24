package ru.bash.jopka.business.status.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.status.model.Status;
import ru.bash.jopka.business.status.repository.StatusRepository;

@Component
@RequiredArgsConstructor
public class FindStatusQuery {
    private final StatusRepository repository;

    public Status execute(long id) {
        return repository.find(id);
    }
}
