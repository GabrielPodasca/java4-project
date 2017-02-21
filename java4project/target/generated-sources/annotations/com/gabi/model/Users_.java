package com.gabi.model;

import com.gabi.model.ProfilDB;
import com.gabi.model.UserRoles;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-27T16:26:24")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile CollectionAttribute<Users, UserRoles> userRolesCollection;
    public static volatile CollectionAttribute<Users, ProfilDB> profilDBCollection;
    public static volatile SingularAttribute<Users, String> parola;
    public static volatile SingularAttribute<Users, Integer> id;
    public static volatile SingularAttribute<Users, Short> enabled;
    public static volatile SingularAttribute<Users, String> username;

}