package ru.bash.jopka.business.status;

import ru.bash.jopka.business.status.model.Status;
import ru.bash.jopka.controller.status.dto.CreateStatusRequest;
import ru.bash.jopka.controller.status.dto.UpdateStatusRequest;

import java.util.Set;

public interface StatusService {
    Status update(UpdateStatusRequest request);
    Status create(CreateStatusRequest request);
    Status find(long id);
    String delete(long id);
    Set<Status> findAll();
}
