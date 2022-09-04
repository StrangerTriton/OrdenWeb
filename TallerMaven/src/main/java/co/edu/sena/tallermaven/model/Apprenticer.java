/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallermaven.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aprendiz
 */
@Entity
@Table(name = "apprentice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apprentice.findAll", query = "SELECT a FROM Apprentice a"),
    @NamedQuery(name = "Apprentice.findByDocument", query = "SELECT a FROM Apprentice a WHERE a.document = :document"),
    @NamedQuery(name = "Apprentice.findByFullName", query = "SELECT a FROM Apprentice a WHERE a.fullName = :fullName")})
public class Apprenticer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "document")
    private Long document;
    @Basic(optional = false)
    @Column(name = "full_name")
    private String fullName;
    @JoinColumn(name = "id_course", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Course idCourse;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentApprentice")
    private Collection<LateArrival> lateArrivalCollection;

    public Apprenticer() {
    }

    public Apprenticer(Long document) {
        this.document = document;
    }

    public Apprenticer(Long document, String fullName) {
        this.document = document;
        this.fullName = fullName;
    }

    public Long getDocument() {
        return document;
    }

    public void setDocument(Long document) {
        this.document = document;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Course getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Course idCourse) {
        this.idCourse = idCourse;
    }

    @XmlTransient
    public Collection<LateArrival> getLateArrivalCollection() {
        return lateArrivalCollection;
    }

    public void setLateArrivalCollection(Collection<LateArrival> lateArrivalCollection) {
        this.lateArrivalCollection = lateArrivalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (document != null ? document.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apprenticer)) {
            return false;
        }
        Apprenticer other = (Apprenticer) object;
        if ((this.document == null && other.document != null) || (this.document != null && !this.document.equals(other.document))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tallermaven.model.Apprentice[ document=" + document + " ]";
    }
    
}
