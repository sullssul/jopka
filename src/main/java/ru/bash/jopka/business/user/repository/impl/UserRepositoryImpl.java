package ru.bash.jopka.business.user.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.user.model.User;
import ru.bash.jopka.business.user.repository.UserRepository;
import ru.bash.jopka.business.user.repository.jpa.JpaUser;
import ru.bash.jopka.business.user.repository.jpa.JpaUserMapper;
import ru.bash.jopka.business.user.repository.jpa.JpaUserRepository;
import ru.bash.jopka.business.user.repository.jpa.JpaUser_;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository repository;
    private final EntityManager entityManager;
    private final JpaUserMapper mapper;

    @Override
    public Optional<User> find(long id) {
        return repository.findById(id)
                .map(mapper::fromJpa);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email)
                .map(mapper::fromJpa);
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
    public Set<User> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::fromJpa)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<User> findByCriteriaQuery(LocalDate birthday,
                                         String city,
                                         String email,
                                         String country,
                                         String phone,
                                         String fatherName,
                                         String firstName,
                                         String secondName,
                                         long organizationId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<JpaUser> criteriaQuery = criteriaBuilder.createQuery(JpaUser.class);
        Root<JpaUser> contactEntityRoot = criteriaQuery.from(JpaUser.class);

        criteriaQuery.select(contactEntityRoot).distinct(true);
        Predicate criteria = criteriaBuilder.conjunction();

        if (birthday != null) {
            Predicate p = criteriaBuilder.equal(contactEntityRoot.get(JpaUser_.birthday), birthday);
            criteria = criteriaBuilder.and(criteria, p);
        }
        if (city != null) {
            Predicate p = criteriaBuilder.equal(contactEntityRoot.get(JpaUser_.city), city);
            criteria = criteriaBuilder.and(criteria, p);
        }
        if (email != null) {
            Predicate p = criteriaBuilder.equal(contactEntityRoot.get(JpaUser_.email), email);
            criteria = criteriaBuilder.and(criteria, p);
        }
        if (country != null) {
            Predicate p = criteriaBuilder.equal(contactEntityRoot.get(JpaUser_.country), country);
            criteria = criteriaBuilder.and(criteria, p);
        }
        if (phone != null) {
            Predicate p = criteriaBuilder.equal(contactEntityRoot.get(JpaUser_.phone), phone);
            criteria = criteriaBuilder.and(criteria, p);
        }
        if (fatherName != null) {
            Predicate p = criteriaBuilder.equal(contactEntityRoot.get(JpaUser_.fatherName), fatherName);
            criteria = criteriaBuilder.and(criteria, p);
        }
        if (secondName != null) {
            Predicate p = criteriaBuilder.equal(contactEntityRoot.get(JpaUser_.secondName), secondName);
            criteria = criteriaBuilder.and(criteria, p);
        }
        if (firstName != null) {
            Predicate p = criteriaBuilder.equal(contactEntityRoot.get(JpaUser_.firstName), firstName);
            criteria = criteriaBuilder.and(criteria, p);
        }
        if (organizationId != 0) {
            Predicate p = criteriaBuilder.equal(contactEntityRoot.get(JpaUser_.organization), organizationId);
            criteria = criteriaBuilder.and(criteria, p);
        }

        criteriaQuery.where(criteria);

        return entityManager.createQuery(criteriaQuery)
                .getResultStream()
                .map(mapper::fromJpa)
                .collect(Collectors.toSet());
    }
}
