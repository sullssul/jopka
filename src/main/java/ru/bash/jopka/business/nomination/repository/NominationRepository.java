package ru.bash.jopka.business.nomination.repository;

import ru.bash.jopka.business.nomination.model.Nomination;

import java.util.Optional;
import java.util.Set;

public interface NominationRepository {
    Optional<Nomination> find(long id);
    Nomination update(Nomination nomination);
    Optional<Nomination> findByName(String name);
    Set<Nomination> findAll();
    void delete(long id);
}
