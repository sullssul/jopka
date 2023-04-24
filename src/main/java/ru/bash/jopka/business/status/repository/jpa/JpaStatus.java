package ru.bash.jopka.business.status.repository.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import ru.bash.jopka.business.picture.repository.jpa.JpaPicture;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "status")
@RequiredArgsConstructor
public class JpaStatus {
    @Column(name = "status_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "status")
    private Set<JpaPicture> pictures;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        JpaStatus status = (JpaStatus) o;
        return id != null && Objects.equals(id, status.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ")";
    }
}
