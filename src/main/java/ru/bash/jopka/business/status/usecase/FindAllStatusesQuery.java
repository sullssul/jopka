package ru.bash.jopka.business.status.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.status.model.Status;
import ru.bash.jopka.business.status.repository.StatusRepository;

import java.util.Set;
@Component
@RequiredArgsConstructor
public class FindAllStatusesQuery {
    private final StatusRepository repository;

    public Set<Status> execute() {
        return repository.findAll();
    }
}
