package ru.bash.jopka.database.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.Hibernate;
import ru.bash.jopka.business.picture.repository.jpa.JpaPicture;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Nomination {
    @Id
    @Column(name = "nomination_id")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "nomination")
    private Set<JpaPicture> pictures;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Nomination that = (Nomination) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
