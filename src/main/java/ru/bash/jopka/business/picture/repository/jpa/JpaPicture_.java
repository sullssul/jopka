package ru.bash.jopka.business.picture.repository.jpa;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import ru.bash.jopka.business.user.repository.jpa.JpaUser;
import ru.bash.jopka.business.nomination.repository.jpa.JpaNomination;
import ru.bash.jopka.business.status.repository.jpa.JpaStatus;

import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(JpaPicture.class)
public abstract class JpaPicture_ {

	public static volatile SingularAttribute<JpaPicture, String> size;
	public static volatile SingularAttribute<JpaPicture, JpaUser> jpaUser;
	public static volatile SingularAttribute<JpaPicture, Integer> ratingValue;
	public static volatile SingularAttribute<JpaPicture, String> name;
	public static volatile SingularAttribute<JpaPicture, Long> id;
	public static volatile SingularAttribute<JpaPicture, String> url;
	public static volatile SingularAttribute<JpaPicture, JpaStatus> status;
	public static volatile SingularAttribute<JpaPicture, JpaNomination> nomination;

	public static final String SIZE = "size";
	public static final String JPA_USER = "jpaUser";
	public static final String RATING_VALUE = "ratingValue";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String URL = "url";
	public static final String STATUS = "status";
	public static final String NOMINATION = "nomination";

}

