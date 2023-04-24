package ru.bash.jopka.business.nomination.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.nomination.model.Nomination;
import ru.bash.jopka.business.nomination.repository.NominationRepository;
import ru.bash.jopka.business.nomination.repository.jpa.JpaNomination;
import ru.bash.jopka.business.nomination.repository.jpa.JpaNominationMapper;
import ru.bash.jopka.business.nomination.repository.jpa.JpaNominationRepository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class NominationRepositoryImpl implements NominationRepository {
    private final JpaNominationRepository repository;
    private final JpaNominationMapper mapper;
    @Override
    public Optional<Nomination> find(long id) {
        return repository.findById(id)
                .map(mapper::fromJpa);
    }

    @Override
    public Nomination update(Nomination nomination) {
        JpaNomination entity = repository.save(mapper.toJpa(nomination));
        return mapper.fromJpa(entity);
    }

    @Override
    public Set<Nomination> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::fromJpa)
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<Nomination> findByName(String name) {
        return repository.findByName(name)
                .map(mapper::fromJpa);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
