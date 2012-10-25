/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author patrick
 */
@Entity
@Table(name = "Technician")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Technician.findAll", query = "SELECT t FROM Technician t"),
    @NamedQuery(name = "Technician.findByTechnicianID", query = "SELECT t FROM Technician t WHERE t.technicianID = :technicianID"),
    @NamedQuery(name = "Technician.findByPersonID", query = "SELECT t FROM Technician t WHERE t.personID = :personID")})
public class Technician extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TechnicianID")
    private Long technicianID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PersonID")
    private long personID;

    public Technician() {
    }

    public Technician(Long technicianID) {
        this.technicianID = technicianID;
    }

    public Technician(Long technicianID, long personID) {
        this.technicianID = technicianID;
        this.personID = personID;
    }

    public Long getTechnicianID() {
        return technicianID;
    }

    public void setTechnicianID(Long technicianID) {
        this.technicianID = technicianID;
    }

    public long getPersonID() {
        return personID;
    }

    public void setPersonID(long personID) {
        this.personID = personID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (technicianID != null ? technicianID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Technician)) {
            return false;
        }
        Technician other = (Technician) object;
        if ((this.technicianID == null && other.technicianID != null) || (this.technicianID != null && !this.technicianID.equals(other.technicianID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "at.sks.scada.business.Technician[ technicianID=" + technicianID + " ]";
    }
    
}
