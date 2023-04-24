package ru.bash.jopka.business.nomination.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bash.jopka.business.nomination.NominationService;
import ru.bash.jopka.business.nomination.model.Nomination;
import ru.bash.jopka.business.nomination.usecase.*;
import ru.bash.jopka.controller.nomimation.dto.CreateNominationRequest;
import ru.bash.jopka.controller.nomimation.dto.UpdateNominationRequest;

import java.util.Optional;
import java.util.Set;
@Service
@RequiredArgsConstructor
public class NominationServiceImpl implements NominationService {
    private final CreateNominationCommand createCommand;
    private final DeleteNominationCommand deleteCommand;
    private final UpdateNominationCommand updateCommand;
    private final FindNominationQuery findQuery;
    private final FindAllNominationsQuery findAllQuery;
    @Override
    public Nomination update(UpdateNominationRequest request) {
        return updateCommand.execute(request);
    }

    @Override
    public Nomination create(CreateNominationRequest request) {
        return createCommand.execute(request);
    }

    @Override
    public Optional<Nomination> find(long id) {
        return findQuery.execute(id);
    }

    @Override
    public String delete(long id) {
        deleteCommand.execute(id);
        return "Роль успешна удалена";
    }

    @Override
    public Set<Nomination> findAll() {
        return findAllQuery.execute();
    }
}
