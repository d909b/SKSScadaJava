/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business;

import at.sks.scada.dal.DataAccessLayerException;
import at.sks.scada.dal.entities.Measurement;
import at.sks.scada.dal.repositories.interfaces.MeasurementRepository;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

/**
 *
 * @author patrick
 */
@Stateless
public class MeasurementService {
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
}
