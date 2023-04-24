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
        Status status = repository.find(id);
        if (status == null) throw new APIException(HttpStatus.NOT_FOUND, "Статус не найдена!");
        return status;
    }
}
