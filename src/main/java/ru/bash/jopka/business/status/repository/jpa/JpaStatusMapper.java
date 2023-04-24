package ru.bash.jopka.business.status.repository.jpa;

import org.springframework.stereotype.Component;
import ru.bash.jopka.business.status.model.Status;

@Component
public class JpaStatusMapper {
    public Status fromJpa(JpaStatus jpaStatus) {
        return Status.builder()
                .id(jpaStatus.getId())
                .name(jpaStatus.getName())
                .build();

    }

    public JpaStatus toJpa(Status status) {
        JpaStatus jpaStatus = new JpaStatus();
        jpaStatus.setId(status.getId());
        jpaStatus.setName(status.getName());
        return jpaStatus;
    }
}
