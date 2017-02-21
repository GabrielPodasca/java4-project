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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "profil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfilDB.findAll", query = "SELECT p FROM ProfilDB p"),
    @NamedQuery(name = "ProfilDB.findById", query = "SELECT p FROM ProfilDB p WHERE p.id = :id"),
    @NamedQuery(name = "ProfilDB.findByNume", query = "SELECT p FROM ProfilDB p WHERE p.nume = :nume"),
    @NamedQuery(name = "ProfilDB.findByPrenume", query = "SELECT p FROM ProfilDB p WHERE p.prenume = :prenume"),
    @NamedQuery(name = "ProfilDB.findByEmail", query = "SELECT p FROM ProfilDB p WHERE p.email = :email"),
    @NamedQuery(name = "ProfilDB.findByTelefon", query = "SELECT p FROM ProfilDB p WHERE p.telefon = :telefon"),
    @NamedQuery(name = "ProfilDB.findByCnp", query = "SELECT p FROM ProfilDB p WHERE p.cnp = :cnp")})
public class ProfilDB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profilId")
    private Collection<PacientDB> pacientDBCollection;
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users usersId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profilId")
    private Collection<MedicDB> medicDBCollection;

    public ProfilDB() {
    }

    public ProfilDB(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @XmlTransient
    public Collection<PacientDB> getPacientDBCollection() {
        return pacientDBCollection;
    }

    public void setPacientDBCollection(Collection<PacientDB> pacientDBCollection) {
        this.pacientDBCollection = pacientDBCollection;
    }

    public Users getUsersId() {
        return usersId;
    }

    public void setUsersId(Users usersId) {
        this.usersId = usersId;
    }

    @XmlTransient
    public Collection<MedicDB> getMedicDBCollection() {
        return medicDBCollection;
    }

    public void setMedicDBCollection(Collection<MedicDB> medicDBCollection) {
        this.medicDBCollection = medicDBCollection;
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
        if (!(object instanceof ProfilDB)) {
            return false;
        }
        ProfilDB other = (ProfilDB) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ro.gabi.model.ProfilDB[ id=" + id + " ]";
    }
    
}
