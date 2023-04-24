package ru.bash.jopka.business.nomination.usecase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.nomination.model.Nomination;
import ru.bash.jopka.business.nomination.repository.NominationRepository;
import ru.bash.jopka.controller.nomimation.dto.CreateNominationRequest;
@Slf4j
@Component
@RequiredArgsConstructor
public class CreateNominationCommand {
    private final NominationRepository repository;
    private final VerifyNominationQuery verifyQuery;

    @Transactional
    public Nomination execute(CreateNominationRequest request) {
        Nomination nomination = buildNomination(request);
        verifyQuery.execute(nomination);

        nomination = repository.update(nomination);
        log.info("Nomination created: " + nomination);
        return nomination;
    }

    private Nomination buildNomination(CreateNominationRequest request) {
        return Nomination.builder()
                .name(request.getName())
                .build();
    }
}
