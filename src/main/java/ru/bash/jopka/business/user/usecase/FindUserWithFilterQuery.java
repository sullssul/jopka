package ru.bash.jopka.business.user.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.user.model.User;
import ru.bash.jopka.business.user.repository.UserRepository;
import ru.bash.jopka.controller.user.dto.FindUserWithFilterRequest;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class FindUserWithFilterQuery {

    private final UserRepository repository;
    public Set<User> execute(FindUserWithFilterRequest request) {
        return repository.findByCriteriaQuery(
                request.getBirthday(),
                request.getCity(),
                request.getEmail(),
                request.getCountry(),
                request.getPhone(),
                request.getFatherName(),
                request.getFirstName(),
                request.getSecondName(),
                request.getOrganizationId()
        );
    }
}
