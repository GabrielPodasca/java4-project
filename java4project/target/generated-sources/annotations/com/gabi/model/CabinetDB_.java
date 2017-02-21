package com.gabi.model;

import com.gabi.model.RegMediciDB;
import com.gabi.model.RegViziteDB;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-27T16:26:24")
@StaticMetamodel(CabinetDB.class)
public class CabinetDB_ { 

    public static volatile CollectionAttribute<CabinetDB, RegMediciDB> regMediciDBCollection;
    public static volatile CollectionAttribute<CabinetDB, RegViziteDB> regViziteDBCollection;
    public static volatile SingularAttribute<CabinetDB, String> denumire;
    public static volatile SingularAttribute<CabinetDB, String> locatie;
    public static volatile SingularAttribute<CabinetDB, Integer> id;

}