/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.presentation;

import at.sks.scada.business.BusinessLayerException;
import at.sks.scada.business.CustomerService;
import at.sks.scada.business.MeasurementService;
import at.sks.scada.business.MeasurementTypeService;
import at.sks.scada.business.SiteService;
import at.sks.scada.dal.entities.Customer;
import at.sks.scada.dal.entities.Measurement;
import at.sks.scada.dal.entities.Site;
import at.sks.scada.presentation.objects.MeasurementObject;
import com.sun.faces.context.flash.ELFlash;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author benny
 */
@ManagedBean(name = "detailPage")
@RequestScoped
public class DetailPage implements Serializable {
    private List<MeasurementObject> measurementModel;
    
    private String siteId;

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public List<MeasurementObject> getMeasurementsModel() {        
        return measurementModel;
    }

    public void setMeasurementsModel(List<MeasurementObject> measurementsModel) {
        this.measurementModel = measurementsModel;
    }
    
    @EJB
    SiteService siteService;
    
    @EJB
    MeasurementTypeService measurementTypeService;
    
    @EJB
    MeasurementService measurementService;
        
    /**
     * Creates a new instance of HomePage
     */
    public DetailPage() {

    }
    
    @PostConstruct
    void init() {
        FacesContext context ;
        context = FacesContext.getCurrentInstance();
        HttpServletRequest myRequest = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpSession mySession = myRequest.getSession();
        
        siteId = myRequest.getParameter("siteId");
        
        List<Measurement> measurements = null;
        try {
            Site site = siteService.getSite(siteId);
            measurements = siteService.getLatestSiteState(site);
        } catch (BusinessLayerException ex) {
            Logger.getLogger(DetailPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<MeasurementObject> measurementResults = new ArrayList<MeasurementObject>();
        
        if(measurements != null) {
            for(Measurement m : measurements) {
                MeasurementObject mo = new MeasurementObject();
                mo.setWert(m.getWert());
                try {
                    mo.setMeasurementType(measurementTypeService.getMeasurementType(m.getMeasurementTypeID().toString()).getUnit());
                    mo.setAvgDay(measurementService.getAverageMeasurement(m, "day"));
                    mo.setAvgMonth(measurementService.getAverageMeasurement(m, "month"));
                    mo.setAvgYear(measurementService.getAverageMeasurement(m, "year"));
                } catch (BusinessLayerException ex) {
                  Logger.getLogger(DetailPage.class.getName()).log(Level.SEVERE, null, ex);
                }
                measurementResults.add(mo);
            }
        }
        measurementModel = measurementResults;
    }
}
