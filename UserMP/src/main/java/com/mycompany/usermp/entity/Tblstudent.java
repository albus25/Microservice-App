/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermp.entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "tblstudent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblstudent.findAll", query = "SELECT t FROM Tblstudent t"),
    @NamedQuery(name = "Tblstudent.findByStudentID", query = "SELECT t FROM Tblstudent t WHERE t.studentID = :studentID"),
    @NamedQuery(name = "Tblstudent.findByStudentName", query = "SELECT t FROM Tblstudent t WHERE t.studentName = :studentName"),
    @NamedQuery(name = "Tblstudent.findByDateOfBirth", query = "SELECT t FROM Tblstudent t WHERE t.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Tblstudent.findByGender", query = "SELECT t FROM Tblstudent t WHERE t.gender = :gender"),
    @NamedQuery(name = "Tblstudent.findByBio", query = "SELECT t FROM Tblstudent t WHERE t.bio = :bio"),
    @NamedQuery(name = "Tblstudent.findByIsPremium", query = "SELECT t FROM Tblstudent t WHERE t.isPremium = :isPremium")})
public class Tblstudent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "studentID")
    private Integer studentID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "studentName")
    private String studentName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "bio")
    private String bio;
    @Column(name = "isPremium")
    private Integer isPremium;
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    @ManyToOne(optional = false)
    private Tbluser userID;

    public Tblstudent() {
    }

    public Tblstudent(Integer studentID) {
        this.studentID = studentID;
    }

    public Tblstudent(Integer studentID, String studentName, Date dateOfBirth, String gender, String bio) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.bio = bio;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Integer getIsPremium() {
        return isPremium;
    }

    public void setIsPremium(Integer isPremium) {
        this.isPremium = isPremium;
    }

    public Tbluser getUserID() {
        return userID;
    }

    public void setUserID(Tbluser userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentID != null ? studentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblstudent)) {
            return false;
        }
        Tblstudent other = (Tblstudent) object;
        if ((this.studentID == null && other.studentID != null) || (this.studentID != null && !this.studentID.equals(other.studentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.usermp.entity.Tblstudent[ studentID=" + studentID + " ]";
    }
    
}
