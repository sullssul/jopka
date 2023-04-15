package ru.bash.jopka.business.role.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.role.repository.RoleRepository;
@Slf4j
@Component
@RequiredArgsConstructor
public class DeleteRoleCommand {
    private final RoleRepository repository;
    private final GetRoleQuery getRoleQuery;

    public void execute(long id) {
        getRoleQuery.execute(id);
        repository.delete(id);
    }
}
