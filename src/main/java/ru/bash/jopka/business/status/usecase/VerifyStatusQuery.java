package ru.bash.jopka.business.status.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.status.model.Status;
import ru.bash.jopka.business.status.repository.StatusRepository;
import ru.bash.jopka.exception.APIException;

import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VerifyStatusQuery {

    private final StatusRepository repository;

    public void execute(Status status) {
        Optional<Status> existing = repository.findByName(status.getName());
        if (existing.isPresent() && !Objects.equals(existing.get().getId(), status.getId())) {
            throw new APIException(HttpStatus.BAD_REQUEST, "Статус c таким названием уже существует!");
        }
    }
}
