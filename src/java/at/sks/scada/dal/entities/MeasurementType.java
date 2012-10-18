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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author patrick
 */
@Entity
@Table(name = "MeasurementType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MeasurementType.findAll", query = "SELECT m FROM MeasurementType m"),
    @NamedQuery(name = "MeasurementType.findByMeasurementTypeID", query = "SELECT m FROM MeasurementType m WHERE m.measurementTypeID = :measurementTypeID"),
    @NamedQuery(name = "MeasurementType.findByMinimum", query = "SELECT m FROM MeasurementType m WHERE m.minimum = :minimum"),
    @NamedQuery(name = "MeasurementType.findByMaximum", query = "SELECT m FROM MeasurementType m WHERE m.maximum = :maximum"),
    @NamedQuery(name = "MeasurementType.findByUnit", query = "SELECT m FROM MeasurementType m WHERE m.unit = :unit")})
public class MeasurementType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MeasurementTypeID")
    private Integer measurementTypeID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Minimum")
    private long minimum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Maximum")
    private long maximum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Unit")
    private String unit;

    public MeasurementType() {
    }

    public MeasurementType(Integer measurementTypeID) {
        this.measurementTypeID = measurementTypeID;
    }

    public MeasurementType(Integer measurementTypeID, long minimum, long maximum, String unit) {
        this.measurementTypeID = measurementTypeID;
        this.minimum = minimum;
        this.maximum = maximum;
        this.unit = unit;
    }

    public Integer getMeasurementTypeID() {
        return measurementTypeID;
    }

    public void setMeasurementTypeID(Integer measurementTypeID) {
        this.measurementTypeID = measurementTypeID;
    }

    public long getMinimum() {
        return minimum;
    }

    public void setMinimum(long minimum) {
        this.minimum = minimum;
    }

    public long getMaximum() {
        return maximum;
    }

    public void setMaximum(long maximum) {
        this.maximum = maximum;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (measurementTypeID != null ? measurementTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MeasurementType)) {
            return false;
        }
        MeasurementType other = (MeasurementType) object;
        if ((this.measurementTypeID == null && other.measurementTypeID != null) || (this.measurementTypeID != null && !this.measurementTypeID.equals(other.measurementTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "at.sks.scada.business.MeasurementType[ measurementTypeID=" + measurementTypeID + " ]";
    }
    
}
