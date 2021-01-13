/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermp.entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "tblstate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblstate.findAll", query = "SELECT t FROM Tblstate t"),
    @NamedQuery(name = "Tblstate.findByStateID", query = "SELECT t FROM Tblstate t WHERE t.stateID = :stateID"),
    @NamedQuery(name = "Tblstate.findByStateName", query = "SELECT t FROM Tblstate t WHERE t.stateName = :stateName"),
    @NamedQuery(name = "Tblstate.findByStatus", query = "SELECT t FROM Tblstate t WHERE t.status = :status")})
public class Tblstate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stateID")
    private Integer stateID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "stateName")
    private String stateName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "countryID", referencedColumnName = "countryID")
    @ManyToOne(optional = false)
    private Tblcountry countryID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateID")
    private Collection<Tblcity> tblcityCollection;

    public Tblstate() {
    }

    public Tblstate(Integer stateID) {
        this.stateID = stateID;
    }

    public Tblstate(Integer stateID, String stateName, int status) {
        this.stateID = stateID;
        this.stateName = stateName;
        this.status = status;
    }

    public Integer getStateID() {
        return stateID;
    }

    public void setStateID(Integer stateID) {
        this.stateID = stateID;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Tblcountry getCountryID() {
        return countryID;
    }

    public void setCountryID(Tblcountry countryID) {
        this.countryID = countryID;
    }

    @XmlTransient
    public Collection<Tblcity> getTblcityCollection() {
        return tblcityCollection;
    }

    public void setTblcityCollection(Collection<Tblcity> tblcityCollection) {
        this.tblcityCollection = tblcityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stateID != null ? stateID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblstate)) {
            return false;
        }
        Tblstate other = (Tblstate) object;
        if ((this.stateID == null && other.stateID != null) || (this.stateID != null && !this.stateID.equals(other.stateID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.usermp.entity.Tblstate[ stateID=" + stateID + " ]";
    }
    
}
