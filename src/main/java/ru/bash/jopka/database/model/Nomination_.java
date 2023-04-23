package ru.bash.jopka.database.model;

import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import ru.bash.jopka.business.picture.repository.jpa.JpaPicture;
import ru.bash.jopka.database.model.Nomination;

import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Nomination.class)
public abstract class Nomination_ {

	public static volatile SingularAttribute<Nomination, String> name;
	public static volatile SingularAttribute<Nomination, Long> id;
	public static volatile SetAttribute<Nomination, JpaPicture> pictures;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String PICTURES = "pictures";

}

