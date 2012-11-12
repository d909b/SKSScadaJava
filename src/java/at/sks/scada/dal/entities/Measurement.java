/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author patrick
 */
@Entity
@Table(name = "Measurement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Measurement.findAll", query = "SELECT m FROM Measurement m"),
    @NamedQuery(name = "Measurement.findByMeasurementID", query = "SELECT m FROM Measurement m WHERE m.measurementID = :measurementID"),
    @NamedQuery(name = "Measurement.findByWert", query = "SELECT m FROM Measurement m WHERE m.wert = :wert"),
    @NamedQuery(name = "Measurement.findByTime", query = "SELECT m FROM Measurement m WHERE m.time_ = :time"),
    @NamedQuery(name = "Measurement.findBySiteID", query = "SELECT m FROM Measurement m WHERE m.siteID = :siteID"),
    @NamedQuery(name = "Measurement.findLatestBySiteID", query = "SELECT m FROM Measurement m WHERE m.siteID = :siteID AND m.time_ = (SELECT max(m2.time_) FROM Measurement m2 WHERE m2.siteID = :siteID)"),
    @NamedQuery(name = "Measurement.findByMeasurementTypeID", query = "SELECT m FROM Measurement m WHERE m.measurementTypeID = :measurementTypeID"),
    @NamedQuery(name = "Measurement.findByCustomerAndByTimerange", query = "SELECT m FROM Measurement m WHERE m.siteID IN (SELECT s.siteID FROM Site s WHERE s.customerID = :customerID) order by m.time_")})
public class Measurement extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MeasurementID")
    private Long measurementID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Wert")
    private float wert;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time_;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SiteID")
    private long siteID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MeasurementTypeID")
    private Long measurementTypeID;

    public Measurement() {
    }

    public Measurement(Long measurementID) {
        this.measurementID = measurementID;
    }

    public Measurement(Long measurementID, float wert, Date time, long siteID, Long measurementTypeID) {
        this.measurementID = measurementID;
        this.wert = wert;
        this.time_ = time;
        this.siteID = siteID;
        this.measurementTypeID = measurementTypeID;
    }

    public Long getMeasurementID() {
        return measurementID;
    }

    public void setMeasurementID(Long measurementID) {
        this.measurementID = measurementID;
    }

    public float getWert() {
        return wert;
    }

    public void setWert(float wert) {
        this.wert = wert;
    }

    public Date getTime() {
        return time_;
    }

    public void setTime(Date time) {
        this.time_ = time;
    }

    public long getSiteID() {
        return siteID;
    }

    public void setSiteID(long siteID) {
        this.siteID = siteID;
    }

    public Long getMeasurementTypeID() {
        return measurementTypeID;
    }

    public void setMeasurementTypeID(Long measurementTypeID) {
        this.measurementTypeID = measurementTypeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (measurementID != null ? measurementID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Measurement)) {
            return false;
        }
        Measurement other = (Measurement) object;
        if ((this.measurementID == null && other.measurementID != null) || (this.measurementID != null && !this.measurementID.equals(other.measurementID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "at.sks.scada.business.Measurement[ measurementID=" + measurementID + " ]";
    }
    
}
