package ru.bash.jopka.business.status.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.status.model.Status;
import ru.bash.jopka.business.status.repository.StatusRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindStatusQuery {
    private final StatusRepository repository;

    public Optional<Status> execute(long id) {
        return repository.find(id);
    }
}
