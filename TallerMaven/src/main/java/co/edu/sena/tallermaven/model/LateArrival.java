/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallermaven.model;

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
 * @author Aprendiz
 */
@Entity
@Table(name = "late_arrival")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LateArrival.findAll", query = "SELECT l FROM LateArrival l"),
    @NamedQuery(name = "LateArrival.findById", query = "SELECT l FROM LateArrival l WHERE l.id = :id"),
    @NamedQuery(name = "LateArrival.findByDateArrival", query = "SELECT l FROM LateArrival l WHERE l.dateArrival = :dateArrival"),
    @NamedQuery(name = "LateArrival.findByObservations", query = "SELECT l FROM LateArrival l WHERE l.observations = :observations")})
public class LateArrival implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "date_arrival")
    @Temporal(TemporalType.DATE)
    private Date dateArrival;
    @Column(name = "observations")
    private String observations;
    @JoinColumn(name = "document_apprentice", referencedColumnName = "document")
    @ManyToOne(optional = false)
    private Apprentice documentApprentice;

    public LateArrival() {
    }

    public LateArrival(Integer id) {
        this.id = id;
    }

    public LateArrival(Integer id, Date dateArrival) {
        this.id = id;
        this.dateArrival = dateArrival;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateArrival() {
        return dateArrival;
    }

    public void setDateArrival(Date dateArrival) {
        this.dateArrival = dateArrival;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Apprentice getDocumentApprentice() {
        return documentApprentice;
    }

    public void setDocumentApprentice(Apprentice documentApprentice) {
        this.documentApprentice = documentApprentice;
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
        if (!(object instanceof LateArrival)) {
            return false;
        }
        LateArrival other = (LateArrival) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tallermaven.model.LateArrival[ id=" + id + " ]";
    }
    
}
