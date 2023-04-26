package ru.bash.jopka.security.jwt.repository.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.time.Instant;
import java.util.Objects;

@Entity(name = "token")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class JpaToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JoinColumn(name = "user_id")
    private long userId;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false)
    private Instant expiryDate;

    @Column(nullable = false)
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        JpaToken jpaToken = (JpaToken) o;
        return getId() != 0 && Objects.equals(getId(), jpaToken.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
