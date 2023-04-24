package ru.bash.jopka.business.nomination.repository.jpa;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import ru.bash.jopka.business.picture.repository.jpa.JpaPicture;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "nomination")
@RequiredArgsConstructor
public class JpaNomination {
    @Id
    @Column(name = "nomination_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "nomination")
    @ToString.Exclude
    private Set<JpaPicture> pictures;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        JpaNomination that = (JpaNomination) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
