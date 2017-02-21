package com.gabi.model;

import com.gabi.model.CabinetDB;
import com.gabi.model.MedicDB;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-27T16:26:24")
@StaticMetamodel(RegMediciDB.class)
public class RegMediciDB_ { 

    public static volatile SingularAttribute<RegMediciDB, CabinetDB> cabineteId;
    public static volatile SingularAttribute<RegMediciDB, Integer> id;
    public static volatile SingularAttribute<RegMediciDB, MedicDB> mediciId;

}