/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.studentmp.entity;

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
@Table(name = "tblcity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblcity.findAll", query = "SELECT t FROM Tblcity t"),
    @NamedQuery(name = "Tblcity.findByCityID", query = "SELECT t FROM Tblcity t WHERE t.cityID = :cityID"),
    @NamedQuery(name = "Tblcity.findByCityName", query = "SELECT t FROM Tblcity t WHERE t.cityName = :cityName"),
    @NamedQuery(name = "Tblcity.findByStatus", query = "SELECT t FROM Tblcity t WHERE t.status = :status")})
public class Tblcity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cityID")
    private Integer cityID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cityName")
    private String cityName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "stateID", referencedColumnName = "stateID")
    @ManyToOne(optional = false)
    private Tblstate stateID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityID")
    private Collection<Tbluser> tbluserCollection;

    public Tblcity() {
    }

    public Tblcity(Integer cityID) {
        this.cityID = cityID;
    }

    public Tblcity(Integer cityID, String cityName, int status) {
        this.cityID = cityID;
        this.cityName = cityName;
        this.status = status;
    }

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Tblstate getStateID() {
        return stateID;
    }

    public void setStateID(Tblstate stateID) {
        this.stateID = stateID;
    }

    @XmlTransient
    public Collection<Tbluser> getTbluserCollection() {
        return tbluserCollection;
    }

    public void setTbluserCollection(Collection<Tbluser> tbluserCollection) {
        this.tbluserCollection = tbluserCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityID != null ? cityID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblcity)) {
            return false;
        }
        Tblcity other = (Tblcity) object;
        if ((this.cityID == null && other.cityID != null) || (this.cityID != null && !this.cityID.equals(other.cityID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.studentmp.entity.Tblcity[ cityID=" + cityID + " ]";
    }
    
}
