package ru.bash.jopka.business.user.repository;

import ru.bash.jopka.business.user.model.User;

import java.util.List;

public interface UserRepository {
    User find(long id);
    User update(User user);
    User findByEmail(String email);
    List<User> findAllByEmailLike(String email);
    void delete(long id);
}
