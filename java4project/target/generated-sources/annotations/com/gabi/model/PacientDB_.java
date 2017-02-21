package com.gabi.model;

import com.gabi.model.ProfilDB;
import com.gabi.model.RegPacientiDB;
import com.gabi.model.RegViziteDB;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-27T16:26:24")
@StaticMetamodel(PacientDB.class)
public class PacientDB_ { 

    public static volatile CollectionAttribute<PacientDB, RegViziteDB> regViziteDBCollection;
    public static volatile SingularAttribute<PacientDB, ProfilDB> profilId;
    public static volatile SingularAttribute<PacientDB, BigDecimal> greutate;
    public static volatile SingularAttribute<PacientDB, BigDecimal> inaltime;
    public static volatile SingularAttribute<PacientDB, Integer> id;
    public static volatile CollectionAttribute<PacientDB, RegPacientiDB> regPacientiDBCollection;

}