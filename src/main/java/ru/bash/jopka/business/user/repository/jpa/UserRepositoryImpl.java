package ru.bash.jopka.business.user.repository.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.user.model.User;
import ru.bash.jopka.business.user.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository repository;
    private final JpaUserMapper mapper;

    @Override
    public User find(long id) {
        return repository.findById(id)
                .map(mapper::fromJpa)
                .orElse(null);
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email)
                .map(mapper::fromJpa)
                .orElse(null);
    }

    @Override
    public User update(User user) {
        JpaUser entity = repository.save(mapper.toJpa(user));
        return mapper.fromJpa(entity);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<User> findAllByEmailLike(String email) {
        return repository.findAllByEmailLike(email)
                .stream()
                .map(mapper::fromJpa)
                .collect(Collectors.toList());
    }
}
