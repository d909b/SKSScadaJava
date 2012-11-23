/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.services.service;

import at.sks.scada.business.BusinessLayerException;
import at.sks.scada.business.MeasurementService;
import at.sks.scada.dal.entities.Measurement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author patrick
 */
@Stateless
@Path("Measurements")
public class MeasurementRESTFacade {
    private static final Logger log = Logger.getLogger(MeasurementRESTFacade.class.getName());
    
    @EJB
    MeasurementService service;

    public MeasurementRESTFacade() {
        
    }
    
    @GET
    @Produces({"application/json"})
    public List<Measurement> getMeasurements() {
        log.entering("MeasurementService", "getMeasurements");
        try {
            return service.getAll();
        } catch (BusinessLayerException ex) {
            Logger.getLogger(MeasurementRESTFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @POST
    @Consumes({"application/json"})
    public void create(Measurement entity) {
        log.entering("MeasurementService", "create");
        try {
            service.createMeasurement(entity);
        } catch (BusinessLayerException ex) {
            Logger.getLogger(MeasurementRESTFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
