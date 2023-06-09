package ru.bash.jopka.business.user.repository;

import ru.bash.jopka.business.user.model.User;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

public interface UserRepository {
    Optional<User> find(long id);
    User update(User user);
    Optional<User> findByEmail(String email);
    Set<User> findAll();
    void delete(long id);
    Set<User> findByCriteriaQuery(LocalDate birthday,
                                  String city,
                                  String email,
                                  String country,
                                  String phone,
                                  String fatherName,
                                  String firstName,
                                  String secondName,
                                  long organizationId);
}
