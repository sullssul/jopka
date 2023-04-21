package ru.bash.jopka.business.organization.repository.jpa;

import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import ru.bash.jopka.business.user.repository.jpa.JpaUser;

import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(JpaOrganization.class)
public abstract class JpaOrganization_ {

	public static volatile SingularAttribute<JpaOrganization, String> name;
	public static volatile SingularAttribute<JpaOrganization, String> description;
	public static volatile SingularAttribute<JpaOrganization, Long> id;
	public static volatile SetAttribute<JpaOrganization, JpaUser> user;

	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String USER = "user";

}

