package ru.bash.jopka.business.status.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.status.StatusService;
import ru.bash.jopka.business.status.model.Status;
import ru.bash.jopka.business.status.usecase.*;
import ru.bash.jopka.controller.status.dto.CreateStatusRequest;
import ru.bash.jopka.controller.status.dto.UpdateStatusRequest;

import java.util.Optional;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class StatusServiceImpl implements StatusService {

    private final CreateStatusCommand createCommand;
    private final DeleteStatusCommand deleteCommand;
    private final UpdateStatusCommand updateCommand;
    private final FindStatusQuery findQuery;
    private final FindAllStatusesQuery findAllQuery;
    @Override
    public Status update(UpdateStatusRequest request) {
        return updateCommand.execute(request);
    }

    @Override
    public Status create(CreateStatusRequest request) {
        return createCommand.execute(request);
    }

    @Override
    public Optional<Status> find(long id) {
        return findQuery.execute(id);
    }

    @Override
    public String delete(long id) {
        deleteCommand.execute(id);
        return "Роль успешна удалена";
    }

    @Override
    public Set<Status> findAll() {
        return findAllQuery.execute();
    }
}
