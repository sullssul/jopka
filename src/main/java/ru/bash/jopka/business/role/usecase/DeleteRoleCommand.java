package ru.bash.jopka.business.role.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.role.repository.RoleRepository;

@Component
@RequiredArgsConstructor
public class DeleteRoleCommand {
    private final RoleRepository repository;
    private final GetRoleQuery getQuery;

    public void execute(long id) {
        getQuery.execute(id);
        repository.delete(id);
    }
}
