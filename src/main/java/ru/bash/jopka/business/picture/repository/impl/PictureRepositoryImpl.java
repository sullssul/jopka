package ru.bash.jopka.business.picture.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.bash.jopka.business.picture.model.Picture;
import ru.bash.jopka.business.picture.repository.PictureRepository;
import ru.bash.jopka.business.picture.repository.jpa.JpaPicture;
import ru.bash.jopka.business.picture.repository.jpa.JpaPictureMapper;
import ru.bash.jopka.business.picture.repository.jpa.JpaPictureRepository;
import ru.bash.jopka.business.picture.repository.jpa.JpaPicture_;
import ru.bash.jopka.business.user.repository.jpa.JpaUser;
import ru.bash.jopka.database.model.Nomination;
import ru.bash.jopka.database.model.Status;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PictureRepositoryImpl implements PictureRepository {

    private final JpaPictureRepository repository;
    private final EntityManager entityManager;
    private final JpaPictureMapper mapper;

    @Override
    public Picture find(long id) {
        return repository.findById(id)
                .map(mapper::fromJpa)
                .orElse(null);
    }

    @Override
    public Picture update(Picture picture) {
        JpaPicture entity = repository.save(mapper.toJpa(picture));
        return mapper.fromJpa(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Picture> findByCriteriaQuery(String name, long userId, long statusId, long nominationId, int ratingValue) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<JpaPicture> criteriaQuery = criteriaBuilder.createQuery(JpaPicture.class);
        Root<JpaPicture> contactEntityRoot = criteriaQuery.from(JpaPicture.class);

        criteriaQuery.select(contactEntityRoot).distinct(true);
        Predicate criteria = criteriaBuilder.conjunction();

        if (name != null) {
            Predicate p = criteriaBuilder.equal(contactEntityRoot.get(JpaPicture_.name), name);
            criteria = criteriaBuilder.and(criteria, p);
        }

        if (userId != 0) {
            JpaUser jpaUser = new JpaUser();
            jpaUser.setId(userId);
            Predicate p = criteriaBuilder.equal(contactEntityRoot.get(JpaPicture_.jpaUser), jpaUser);
            criteria = criteriaBuilder.and(criteria, p);
        }

        if (statusId != 0) {
            Status status = new Status();
            status.setId(statusId);
            Predicate p = criteriaBuilder.equal(contactEntityRoot.get(JpaPicture_.status), status);
            criteria = criteriaBuilder.and(criteria, p);
        }

        if (nominationId != 0) {
            Nomination nomination = new Nomination();
            nomination.setId(statusId);
            Predicate p = criteriaBuilder.equal(contactEntityRoot.get(JpaPicture_.nomination), nomination);
            criteria = criteriaBuilder.and(criteria, p);
        }

        if (ratingValue != 0) {
            Predicate p = criteriaBuilder.equal(contactEntityRoot.get(JpaPicture_.ratingValue), ratingValue);
            criteria = criteriaBuilder.and(criteria, p);
        }

        criteriaQuery.where(criteria);

        return entityManager.createQuery(criteriaQuery)
                .getResultStream()
                .map(mapper::fromJpa)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Picture> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::fromJpa)
                .collect(Collectors.toSet());
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
