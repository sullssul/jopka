package ru.bash.jopka.database.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import ru.bash.jopka.business.user.repository.jpa.JpaUser;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Picture {
    @Id
    @Column(name = "picture_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String size;
    private int ratingValue;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private JpaUser jpaUser;
    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;
    @ManyToOne
    @JoinColumn(name = "nomination_id", nullable = false)
    private Nomination nomination;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Picture picture = (Picture) o;
        return id != null && Objects.equals(id, picture.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
