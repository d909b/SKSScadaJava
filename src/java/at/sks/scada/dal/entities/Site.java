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
@Table(name = "Site")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Site.findAll", query = "SELECT s FROM Site s"),
    @NamedQuery(name = "Site.findBySerialnumber", query = "SELECT s FROM Site s WHERE s.serialnumber = :serialnumber"),
    @NamedQuery(name = "Site.findByLongitude", query = "SELECT s FROM Site s WHERE s.longitude = :longitude"),
    @NamedQuery(name = "Site.findByLatitude", query = "SELECT s FROM Site s WHERE s.latitude = :latitude"),
    @NamedQuery(name = "Site.findByDescription", query = "SELECT s FROM Site s WHERE s.description = :description"),
    @NamedQuery(name = "Site.findByCustomerID", query = "SELECT s FROM Site s WHERE s.customerID = :customerID"),
    @NamedQuery(name = "Site.findBySiteID", query = "SELECT s FROM Site s WHERE s.siteID = :siteID")})
public class Site implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Serialnumber")
    private String serialnumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Longitude")
    private float longitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Latitude")
    private float latitude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CustomerID")
    private long customerID;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SiteID")
    private Long siteID;

    public Site() {
    }

    public Site(Long siteID) {
        this.siteID = siteID;
    }

    public Site(Long siteID, String serialnumber, float longitude, float latitude, String description, long customerID) {
        this.siteID = siteID;
        this.serialnumber = serialnumber;
        this.longitude = longitude;
        this.latitude = latitude;
        this.description = description;
        this.customerID = customerID;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public Long getSiteID() {
        return siteID;
    }

    public void setSiteID(Long siteID) {
        this.siteID = siteID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (siteID != null ? siteID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Site)) {
            return false;
        }
        Site other = (Site) object;
        if ((this.siteID == null && other.siteID != null) || (this.siteID != null && !this.siteID.equals(other.siteID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "at.sks.scada.business.Site[ siteID=" + siteID + " ]";
    }
    
}
