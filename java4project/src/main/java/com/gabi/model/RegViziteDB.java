/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabi.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gabi
 */
@Entity
@Table(name = "reg_vizite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegViziteDB.findAll", query = "SELECT r FROM RegViziteDB r"),
    @NamedQuery(name = "RegViziteDB.findById", query = "SELECT r FROM RegViziteDB r WHERE r.id = :id"),
    @NamedQuery(name = "RegViziteDB.findByDataVizita", query = "SELECT r FROM RegViziteDB r WHERE r.dataVizita = :dataVizita")})
public class RegViziteDB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data_vizita")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVizita;
    @JoinColumn(name = "cabinete_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CabinetDB cabineteId;
    @JoinColumn(name = "pacienti_users_id", referencedColumnName = "users_id")
    @ManyToOne(optional = false)
    private PacientDB pacientiUsersId;
    @JoinColumn(name = "medici_users_id", referencedColumnName = "users_id")
    @ManyToOne(optional = false)
    private MedicDB mediciUsersId;

    public RegViziteDB() {
    }

    public RegViziteDB(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataVizita() {
        return dataVizita;
    }

    public void setDataVizita(Date dataVizita) {
        this.dataVizita = dataVizita;
    }

    public CabinetDB getCabineteId() {
        return cabineteId;
    }

    public void setCabineteId(CabinetDB cabineteId) {
        this.cabineteId = cabineteId;
    }

    public PacientDB getPacientiUsersId() {
        return pacientiUsersId;
    }

    public void setPacientiUsersId(PacientDB pacientiUsersId) {
        this.pacientiUsersId = pacientiUsersId;
    }

    public MedicDB getMediciUsersId() {
        return mediciUsersId;
    }

    public void setMediciUsersId(MedicDB mediciUsersId) {
        this.mediciUsersId = mediciUsersId;
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
        if (!(object instanceof RegViziteDB)) {
            return false;
        }
        RegViziteDB other = (RegViziteDB) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gabi.model.RegViziteDB[ id=" + id + " ]";
    }
    
}
