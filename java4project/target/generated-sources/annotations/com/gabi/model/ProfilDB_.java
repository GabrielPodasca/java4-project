package com.gabi.model;

import com.gabi.model.MedicDB;
import com.gabi.model.PacientDB;
import com.gabi.model.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-27T16:26:24")
@StaticMetamodel(ProfilDB.class)
public class ProfilDB_ { 

    public static volatile CollectionAttribute<ProfilDB, PacientDB> pacientDBCollection;
    public static volatile SingularAttribute<ProfilDB, String> cnp;
    public static volatile CollectionAttribute<ProfilDB, MedicDB> medicDBCollection;
    public static volatile SingularAttribute<ProfilDB, String> telefon;
    public static volatile SingularAttribute<ProfilDB, String> prenume;
    public static volatile SingularAttribute<ProfilDB, Users> usersId;
    public static volatile SingularAttribute<ProfilDB, Integer> id;
    public static volatile SingularAttribute<ProfilDB, String> nume;
    public static volatile SingularAttribute<ProfilDB, String> email;

}