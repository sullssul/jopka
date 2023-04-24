package ru.bash.jopka.business.status.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.status.model.Status;
import ru.bash.jopka.business.status.repository.StatusRepository;
import ru.bash.jopka.business.status.repository.jpa.JpaStatus;
import ru.bash.jopka.business.status.repository.jpa.JpaStatusMapper;
import ru.bash.jopka.business.status.repository.jpa.JpaStatusRepository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StatusRepositoryImpl implements StatusRepository {

    private final JpaStatusRepository repository;
    private final JpaStatusMapper mapper;
    @Override
    public Status find(long id) {
        return repository.findById(id)
                .map(mapper::fromJpa)
                .orElse(null);
    }

    @Override
    public Status update(Status status) {
        JpaStatus entity = repository.save(mapper.toJpa(status));
        return mapper.fromJpa(entity);
    }

    @Override
    public Optional<Status> findByName(String name) {
        return repository.findByName(name)
                .map(mapper::fromJpa);
    }

    @Override
    public Set<Status> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::fromJpa)
                .collect(Collectors.toSet());
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
