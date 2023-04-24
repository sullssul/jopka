package ru.bash.jopka.business.status.usecase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.status.model.Status;
import ru.bash.jopka.business.status.repository.StatusRepository;
import ru.bash.jopka.controller.dto.status.CreateStatusRequest;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateStatusCommand {
    private final StatusRepository repository;
    private final VerifyStatusQuery verifyQuery;

    @Transactional
    public Status execute(CreateStatusRequest request) {
        Status status = buildRole(request);
        verifyQuery.execute(status);

        status = repository.update(status);
        log.info("Status created: " + status);
        return status;
    }

    private Status buildRole(CreateStatusRequest request) {
        return Status.builder()
                .name(request.getName())
                .build();
    }
}
