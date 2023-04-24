package ru.bash.jopka.business.status.repository;

import ru.bash.jopka.business.status.model.Status;

import java.util.Optional;
import java.util.Set;

public interface StatusRepository {
    Optional<Status> find(long id);
    Status update(Status status);
    Optional<Status> findByName(String name);
    Set<Status> findAll();
    void delete(long id);
}
