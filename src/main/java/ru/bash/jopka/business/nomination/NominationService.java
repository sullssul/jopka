package ru.bash.jopka.business.nomination;

import ru.bash.jopka.business.nomination.model.Nomination;
import ru.bash.jopka.controller.nomimation.dto.CreateNominationRequest;
import ru.bash.jopka.controller.nomimation.dto.UpdateNominationRequest;

import java.util.Optional;
import java.util.Set;

public interface NominationService {
    Nomination update(UpdateNominationRequest request);
    Nomination create(CreateNominationRequest request);
    Optional<Nomination> find(long id);
    String delete(long id);
    Set<Nomination> findAll();
}
