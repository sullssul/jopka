package ru.bash.jopka.business.user.repository.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.bash.jopka.business.organization.repository.jpa.JpaOrganization;
import ru.bash.jopka.business.picture.repository.jpa.JpaPicture;
import ru.bash.jopka.business.role.repository.jpa.JpaRole;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;


@Entity(name = "users")
@Getter
@Setter
@RequiredArgsConstructor
public class JpaUser implements UserDetails {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String secondName;
    private String fatherName;
    private String city;
    private String country;
    private LocalDate birthday;
    private String faculty;
    private String supervisorFullName;
    private String supervisorPosition;
    private String supervisorPhoneNumber;
    private String aboutMe;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private String phone;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<JpaRole> roles;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "jpaUser")
    private Set<JpaPicture> pictures;
    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private JpaOrganization organization;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o != null) {
            Hibernate.getClass(this);
            Hibernate.getClass(o);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "firstName = " + firstName + ", " +
                "secondName = " + secondName + ", " +
                "fatherName = " + fatherName + ", " +
                "city = " + city + ", " +
                "county = " + country + ", " +
                "aboutMe = " + aboutMe + ", " +
                "email = " + email + ", " +
                "password = " + password + ", " +
                "phone = " + phone + ", " +
                "organization = " + organization + ")";
    }
}
