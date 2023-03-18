package ru.bash.jopka.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bash.jopka.database.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
}
