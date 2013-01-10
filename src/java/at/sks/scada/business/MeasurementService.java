/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business;

import at.sks.scada.business.interfaces.MeasurementServiceInterface;
import at.sks.scada.dal.DataAccessLayerException;
import at.sks.scada.dal.entities.Measurement;
import at.sks.scada.dal.repositories.interfaces.MeasurementRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

/**
 *
 * @author patrick
 */
@Stateless
public class MeasurementService{
    private static final Logger log = Logger.getLogger(CustomerService.class.getName());
    
    @EJB(beanName="MeasurementRepository")    
    private MeasurementRepository measurementRepository;
    
    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    public MeasurementService() {
        
    }
    
    public MeasurementService(MeasurementRepository mi) {
        this.measurementRepository = mi;
    }
    
    public List<Measurement> getAll() throws BusinessLayerException {
        log.entering("MeasurementService", "getAll");
        
        try {
            return measurementRepository.findByNamedQuery("Measurement.findAll");
        } catch (DataAccessLayerException ex) {
            Logger.getLogger(MeasurementService.class.getName()).log(Level.SEVERE, null, ex);
            throw new BusinessLayerException(ex);
        }
    }
    
    public void createMeasurement(Measurement m) throws BusinessLayerException {
        log.entering("MeasurementService", "createMeasurement");
        
        try {
            measurementRepository.add(m);
        } catch (DataAccessLayerException ex) {
            Logger.getLogger(MeasurementService.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            throw new BusinessLayerException(ex);
        }
    }
    
    public String getAverageMeasurement(Measurement m, String interval) throws BusinessLayerException{
        log.entering("MeasurementService", "averageMeasurementByDay");
        Map<String,Object> parameters = new HashMap<String, Object>();
        parameters.put("siteID", m.getSiteID());
        parameters.put("measurementTypeID", m.getMeasurementTypeID());
        
        try {
            if(interval.equals("day")) {
                return measurementRepository.findByNamedQueryWithParameters("Measurement.findAverageByDay", parameters).toString();
            } else if(interval.equals("month")) {
                return measurementRepository.findByNamedQueryWithParameters("Measurement.findAverageByMonth", parameters).toString();
            } else if(interval.equals("year")) {
                return measurementRepository.findByNamedQueryWithParameters("Measurement.findAverageByYear", parameters).toString();
            }
        } catch (DataAccessLayerException ex) {
            Logger.getLogger(MeasurementService.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            throw new BusinessLayerException(ex);
        }
        return null;
    }
}
