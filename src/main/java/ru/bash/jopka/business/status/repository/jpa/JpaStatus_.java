package ru.bash.jopka.business.status.repository.jpa;

import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import ru.bash.jopka.business.picture.repository.jpa.JpaPicture;

import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(JpaStatus.class)
public abstract class JpaStatus_ {

	public static volatile SingularAttribute<JpaStatus, String> name;
	public static volatile SingularAttribute<JpaStatus, Long> id;
	public static volatile SetAttribute<JpaStatus, JpaPicture> pictures;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String PICTURES = "pictures";

}

