package ru.bash.jopka.model;

import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import ru.bash.jopka.business.picture.repository.jpa.JpaPicture;
import ru.bash.jopka.database.model.Status;

import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Status.class)
public abstract class Status_ {

	public static volatile SingularAttribute<Status, String> name;
	public static volatile SingularAttribute<Status, Long> id;
	public static volatile SetAttribute<Status, JpaPicture> pictures;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String PICTURES = "pictures";

}

