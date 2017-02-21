package com.gabi.model;

import com.gabi.model.CabinetDB;
import com.gabi.model.MedicDB;
import com.gabi.model.PacientDB;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-27T16:26:24")
@StaticMetamodel(RegViziteDB.class)
public class RegViziteDB_ { 

    public static volatile SingularAttribute<RegViziteDB, PacientDB> pacientiId;
    public static volatile SingularAttribute<RegViziteDB, CabinetDB> cabineteId;
    public static volatile SingularAttribute<RegViziteDB, Integer> id;
    public static volatile SingularAttribute<RegViziteDB, Date> dataVizita;
    public static volatile SingularAttribute<RegViziteDB, MedicDB> mediciId;

}