/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermp.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Entity
@Table(name = "tblcountry")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblcountry.findAll", query = "SELECT t FROM Tblcountry t"),
    @NamedQuery(name = "Tblcountry.findByCountryID", query = "SELECT t FROM Tblcountry t WHERE t.countryID = :countryID"),
    @NamedQuery(name = "Tblcountry.findByCountryName", query = "SELECT t FROM Tblcountry t WHERE t.countryName = :countryName"),
    @NamedQuery(name = "Tblcountry.findByStatus", query = "SELECT t FROM Tblcountry t WHERE t.status = :status")})
public class Tblcountry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "countryID")
    private Integer countryID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "countryName")
    private String countryName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countryID")
    private Collection<Tblstate> tblstateCollection;

    public Tblcountry() {
    }

    public Tblcountry(Integer countryID) {
        this.countryID = countryID;
    }

    public Tblcountry(Integer countryID, String countryName, int status) {
        this.countryID = countryID;
        this.countryName = countryName;
        this.status = status;
    }

    public Integer getCountryID() {
        return countryID;
    }

    public void setCountryID(Integer countryID) {
        this.countryID = countryID;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @JsonbTransient
    public Collection<Tblstate> getTblstateCollection() {
        return tblstateCollection;
    }

    public void setTblstateCollection(Collection<Tblstate> tblstateCollection) {
        this.tblstateCollection = tblstateCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryID != null ? countryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblcountry)) {
            return false;
        }
        Tblcountry other = (Tblcountry) object;
        if ((this.countryID == null && other.countryID != null) || (this.countryID != null && !this.countryID.equals(other.countryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.usermp.entity.Tblcountry[ countryID=" + countryID + " ]";
    }
    
}
