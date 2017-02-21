package com.gabi.model;

import com.gabi.model.ProfilDB;
import com.gabi.model.RegMediciDB;
import com.gabi.model.RegPacientiDB;
import com.gabi.model.RegViziteDB;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-27T16:26:24")
@StaticMetamodel(MedicDB.class)
public class MedicDB_ { 

    public static volatile CollectionAttribute<MedicDB, RegMediciDB> regMediciDBCollection;
    public static volatile CollectionAttribute<MedicDB, RegViziteDB> regViziteDBCollection;
    public static volatile SingularAttribute<MedicDB, String> specialitate;
    public static volatile SingularAttribute<MedicDB, ProfilDB> profilId;
    public static volatile SingularAttribute<MedicDB, Integer> id;
    public static volatile SingularAttribute<MedicDB, String> statut;
    public static volatile CollectionAttribute<MedicDB, RegPacientiDB> regPacientiDBCollection;

}