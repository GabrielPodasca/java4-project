/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabi.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "pacienti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PacientDB.findAll", query = "SELECT p FROM PacientDB p"),
    @NamedQuery(name = "PacientDB.findByUsersId", query = "SELECT p FROM PacientDB p WHERE p.usersId = :usersId"),
    @NamedQuery(name = "PacientDB.findByNume", query = "SELECT p FROM PacientDB p WHERE p.nume = :nume"),
    @NamedQuery(name = "PacientDB.findByPrenume", query = "SELECT p FROM PacientDB p WHERE p.prenume = :prenume"),
    @NamedQuery(name = "PacientDB.findByEmail", query = "SELECT p FROM PacientDB p WHERE p.email = :email"),
    @NamedQuery(name = "PacientDB.findByTelefon", query = "SELECT p FROM PacientDB p WHERE p.telefon = :telefon"),
    @NamedQuery(name = "PacientDB.findByCnp", query = "SELECT p FROM PacientDB p WHERE p.cnp = :cnp"),
    @NamedQuery(name = "PacientDB.findByInaltime", query = "SELECT p FROM PacientDB p WHERE p.inaltime = :inaltime"),
    @NamedQuery(name = "PacientDB.findByGreutate", query = "SELECT p FROM PacientDB p WHERE p.greutate = :greutate")})
public class PacientDB implements Serializable {

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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "inaltime")
    private BigDecimal inaltime;
    @Column(name = "greutate")
    private BigDecimal greutate;
    @JoinColumn(name = "users_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Users users;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacientiUsersId")
    private Collection<RegViziteDB> regViziteDBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacientiUsersId")
    private Collection<RegPacientiDB> regPacientiDBCollection;

    public PacientDB() {
    }

    public PacientDB(Integer usersId) {
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

    public BigDecimal getInaltime() {
        return inaltime;
    }

    public void setInaltime(BigDecimal inaltime) {
        this.inaltime = inaltime;
    }

    public BigDecimal getGreutate() {
        return greutate;
    }

    public void setGreutate(BigDecimal greutate) {
        this.greutate = greutate;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @XmlTransient
    public Collection<RegViziteDB> getRegViziteDBCollection() {
        return regViziteDBCollection;
    }

    public void setRegViziteDBCollection(Collection<RegViziteDB> regViziteDBCollection) {
        this.regViziteDBCollection = regViziteDBCollection;
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
        if (!(object instanceof PacientDB)) {
            return false;
        }
        PacientDB other = (PacientDB) object;
        if ((this.usersId == null && other.usersId != null) || (this.usersId != null && !this.usersId.equals(other.usersId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gabi.model.PacientDB[ usersId=" + usersId + " ]";
    }
    
}
