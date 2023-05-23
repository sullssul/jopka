package ru.bash.jopka.business.user.repository.jpa;

import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import ru.bash.jopka.business.organization.repository.jpa.JpaOrganization;
import ru.bash.jopka.business.picture.repository.jpa.JpaPicture;
import ru.bash.jopka.business.role.repository.jpa.JpaRole;

import javax.annotation.processing.Generated;
import java.time.LocalDate;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(JpaUser.class)
public abstract class JpaUser_ {

	public static volatile SingularAttribute<JpaUser, LocalDate> birthday;
	public static volatile SingularAttribute<JpaUser, String> fatherName;
	public static volatile SingularAttribute<JpaUser, String> country;
	public static volatile SingularAttribute<JpaUser, String> city;
	public static volatile SetAttribute<JpaUser, JpaRole> roles;
	public static volatile SetAttribute<JpaUser, JpaPicture> pictures;
	public static volatile SingularAttribute<JpaUser, String> aboutMe;
	public static volatile SingularAttribute<JpaUser, String> firstName;
	public static volatile SingularAttribute<JpaUser, String> password;
	public static volatile SingularAttribute<JpaUser, String> phone;
	public static volatile SingularAttribute<JpaUser, String> faculty;
	public static volatile SingularAttribute<JpaUser, String> supervisorFullName;
	public static volatile SingularAttribute<JpaUser, String> supervisorPosition;
	public static volatile SingularAttribute<JpaUser, String> supervisorPhoneNumber;
	public static volatile SingularAttribute<JpaUser, JpaOrganization> organization;
	public static volatile SingularAttribute<JpaUser, Long> id;
	public static volatile SingularAttribute<JpaUser, String> email;
	public static volatile SingularAttribute<JpaUser, String> secondName;

	public static final String BIRTHDAY = "birthday";
	public static final String FATHER_NAME = "fatherName";
	public static final String COUNTRY = "country";
	public static final String CITY = "city";
	public static final String ROLES = "roles";
	public static final String PICTURES = "pictures";
	public static final String ABOUT_ME = "aboutMe";
	public static final String FIRST_NAME = "firstName";
	public static final String PASSWORD = "password";
	public static final String PHONE = "phone";
	public static final String ORGANIZATION = "organization";
	public static final String ID = "id";
	public static final String EMAIL = "email";
	public static final String SECOND_NAME = "secondName";
	public static final String FACULTY = "faculty";
	public static final String SUPERVISOR_FULL_NAME = "supervisorFullName";
	public static final String SUPERVISOR_POSITION = "supervisorPosition";
	public static final String SUPERVISOR_PHONE_NUMBER = "supervisorPhoneNumber";

}

