package ru.bash.jopka.business.nomination.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.nomination.model.Nomination;
import ru.bash.jopka.business.nomination.repository.NominationRepository;
import ru.bash.jopka.controller.nomimation.dto.UpdateNominationRequest;
@Component
@RequiredArgsConstructor
public class UpdateNominationCommand {
    private final NominationRepository repository;
    private final GetNominationQuery getQuery;
    private final VerifyNominationQuery verifyQuery;

    public Nomination execute(UpdateNominationRequest request) {
        Nomination nomination = getQuery.execute(request.getId());
        nomination.setName(request.getName());
        verifyQuery.execute(nomination);
        return repository.update(nomination);
    }
}
