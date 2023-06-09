package ru.bash.jopka.business.status.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.status.model.Status;
import ru.bash.jopka.business.status.repository.StatusRepository;
import ru.bash.jopka.exception.APIException;

@Component
@RequiredArgsConstructor
public class GetStatusQuery {
    private final StatusRepository repository;

    public Status execute(long id) {
        return repository.find(id)
                .orElseThrow(() ->
                        new APIException(HttpStatus.NOT_FOUND, "Статус c id: " + id + " - не найден!")
                );
    }
}
