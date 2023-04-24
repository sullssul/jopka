package ru.bash.jopka.business.picture.repository.jpa;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import ru.bash.jopka.business.user.repository.jpa.JpaUser;
import ru.bash.jopka.business.nomination.repository.jpa.Nomination;
import ru.bash.jopka.business.status.repository.jpa.JpaStatus;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Table(name = "picture")
@RequiredArgsConstructor
public class JpaPicture {
    @Id
    @Column(name = "picture_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String size;
    private String url;
    private int ratingValue;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private JpaUser jpaUser;
    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private JpaStatus status;
    @ManyToOne
    @JoinColumn(name = "nomination_id", nullable = false)
    private Nomination nomination;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        JpaPicture picture = (JpaPicture) o;
        return id != null && Objects.equals(id, picture.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
