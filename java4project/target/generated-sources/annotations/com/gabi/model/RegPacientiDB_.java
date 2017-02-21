package com.gabi.model;

import com.gabi.model.MedicDB;
import com.gabi.model.PacientDB;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-27T16:26:24")
@StaticMetamodel(RegPacientiDB.class)
public class RegPacientiDB_ { 

    public static volatile SingularAttribute<RegPacientiDB, PacientDB> pacientiId;
    public static volatile SingularAttribute<RegPacientiDB, Integer> id;
    public static volatile SingularAttribute<RegPacientiDB, MedicDB> mediciId;

}