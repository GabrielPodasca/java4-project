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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gabi
 */
@Entity
@Table(name = "medici")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedicDB.findAll", query = "SELECT m FROM MedicDB m"),
    @NamedQuery(name = "MedicDB.findByUsersId", query = "SELECT m FROM MedicDB m WHERE m.usersId = :usersId"),
    @NamedQuery(name = "MedicDB.findByNume", query = "SELECT m FROM MedicDB m WHERE m.nume = :nume"),
    @NamedQuery(name = "MedicDB.findByPrenume", query = "SELECT m FROM MedicDB m WHERE m.prenume = :prenume"),
    @NamedQuery(name = "MedicDB.findByEmail", query = "SELECT m FROM MedicDB m WHERE m.email = :email"),
    @NamedQuery(name = "MedicDB.findByTelefon", query = "SELECT m FROM MedicDB m WHERE m.telefon = :telefon"),
    @NamedQuery(name = "MedicDB.findByCnp", query = "SELECT m FROM MedicDB m WHERE m.cnp = :cnp"),
    @NamedQuery(name = "MedicDB.findByStatut", query = "SELECT m FROM MedicDB m WHERE m.statut = :statut"),
    @NamedQuery(name = "MedicDB.findBySpecialitate", query = "SELECT m FROM MedicDB m WHERE m.specialitate = :specialitate")})
public class MedicDB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "users_id")
    private Integer usersId;
    @Size(max = 200)
    @Column(name = "nume")
    private String nume;
    @Size(max = 200)
    @Column(name = "prenume")
    private String prenume;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "telefon")
    private String telefon;
    @Size(max = 45)
    @Column(name = "cnp")
    private String cnp;
    @Size(max = 10)
    @Column(name = "statut")
    private String statut;
    @Size(max = 100)
    @Column(name = "specialitate")
    private String specialitate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mediciUsersId")
    private Collection<RegMediciDB> regMediciDBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mediciUsersId")
    private Collection<RegViziteDB> regViziteDBCollection;
    @JoinColumn(name = "users_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Users users;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mediciUsersId")
    private Collection<RegPacientiDB> regPacientiDBCollection;

    public MedicDB() {
    }

    public MedicDB(Integer usersId) {
        this.usersId = usersId;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getSpecialitate() {
        return specialitate;
    }

    public void setSpecialitate(String specialitate) {
        this.specialitate = specialitate;
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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @XmlTransient
    public Collection<RegPacientiDB> getRegPacientiDBCollection() {
        return regPacientiDBCollection;
    }

    public void setRegPacientiDBCollection(Collection<RegPacientiDB> regPacientiDBCollection) {
        this.regPacientiDBCollection = regPacientiDBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usersId != null ? usersId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicDB)) {
            return false;
        }
        MedicDB other = (MedicDB) object;
        if ((this.usersId == null && other.usersId != null) || (this.usersId != null && !this.usersId.equals(other.usersId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gabi.model.MedicDB[ usersId=" + usersId + " ]";
    }
    
}
