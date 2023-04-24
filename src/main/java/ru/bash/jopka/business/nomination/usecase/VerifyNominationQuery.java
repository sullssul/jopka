package ru.bash.jopka.business.nomination.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.nomination.model.Nomination;
import ru.bash.jopka.business.nomination.repository.NominationRepository;
import ru.bash.jopka.exception.APIException;

import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VerifyNominationQuery {

    private final NominationRepository repository;

    public void execute(Nomination nomination) {
        Optional<Nomination> existingNomination = repository.findByName(nomination.getName());
        if (existingNomination.isPresent() && !Objects.equals(existingNomination.get().getId(), nomination.getId())) {
            throw new APIException(HttpStatus.BAD_REQUEST, "Номинация c таким названием уже существует!");
        }
    }
}
