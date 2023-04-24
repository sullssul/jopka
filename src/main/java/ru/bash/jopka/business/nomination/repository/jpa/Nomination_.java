package ru.bash.jopka.business.nomination.repository.jpa;

import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import ru.bash.jopka.business.picture.repository.jpa.JpaPicture;

import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(JpaNomination.class)
public abstract class Nomination_ {

	public static volatile SingularAttribute<JpaNomination, String> name;
	public static volatile SingularAttribute<JpaNomination, Long> id;
	public static volatile SetAttribute<JpaNomination, JpaPicture> pictures;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String PICTURES = "pictures";

}

