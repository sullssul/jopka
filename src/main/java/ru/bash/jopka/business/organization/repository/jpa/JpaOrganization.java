package ru.bash.jopka.business.organization.repository.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import ru.bash.jopka.business.user.repository.jpa.JpaUser;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="organization")
@RequiredArgsConstructor
public class JpaOrganization {
    @Id
    @Column(name = "organization_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "organization")
    private Set<JpaUser> user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        JpaOrganization that = (JpaOrganization) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "description = " + description + ")";
    }
}
