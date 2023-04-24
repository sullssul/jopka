package ru.bash.jopka.business.status.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.status.model.Status;
import ru.bash.jopka.business.status.repository.StatusRepository;
import ru.bash.jopka.controller.status.dto.UpdateStatusRequest;

@Component
@RequiredArgsConstructor
public class UpdateStatusCommand {
    private final StatusRepository repository;
    private final GetStatusQuery getRoleQuery;
    private final VerifyStatusQuery verifyQuery;

    public Status execute(UpdateStatusRequest request) {
        Status status = getRoleQuery.execute(request.getId());
        status.setName(request.getName());
        verifyQuery.execute(status);
        return repository.update(status);
    }
}
