/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabi.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gabi
 */
@Entity
@Table(name = "cabinete")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CabinetDB.findAll", query = "SELECT c FROM CabinetDB c"),
    @NamedQuery(name = "CabinetDB.findById", query = "SELECT c FROM CabinetDB c WHERE c.id = :id"),
    @NamedQuery(name = "CabinetDB.findByDenumire", query = "SELECT c FROM CabinetDB c WHERE c.denumire = :denumire"),
    @NamedQuery(name = "CabinetDB.findByLocatie", query = "SELECT c FROM CabinetDB c WHERE c.locatie = :locatie")})
public class CabinetDB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "denumire")
    private String denumire;
    @Size(max = 200)
    @Column(name = "locatie")
    private String locatie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cabineteId")
    private Collection<RegMediciDB> regMediciDBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cabineteId")
    private Collection<RegViziteDB> regViziteDBCollection;

    public CabinetDB() {
    }

    public CabinetDB(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    @XmlTransient
    public Collection<RegMediciDB> getRegMediciDBCollection() {
        return regMediciDBCollection;
    }

    public void setRegMediciDBCollection(Collection<RegMediciDB> regMediciDBCollection) {
        this.regMediciDBCollection = regMediciDBCollection;
    }

    @XmlTransient
    public Collection<RegViziteDB> getRegViziteDBCollection() {
        return regViziteDBCollection;
    }

    public void setRegViziteDBCollection(Collection<RegViziteDB> regViziteDBCollection) {
        this.regViziteDBCollection = regViziteDBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CabinetDB)) {
            return false;
        }
        CabinetDB other = (CabinetDB) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gabi.model.CabinetDB[ id=" + id + " ]";
    }
    
}
