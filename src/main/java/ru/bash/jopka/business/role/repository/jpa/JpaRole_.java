package ru.bash.jopka.business.role.repository.jpa;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(JpaRole.class)
public abstract class JpaRole_ {

	public static volatile SingularAttribute<JpaRole, String> name;
	public static volatile SingularAttribute<JpaRole, Long> id;

	public static final String NAME = "name";
	public static final String ID = "id";

}

