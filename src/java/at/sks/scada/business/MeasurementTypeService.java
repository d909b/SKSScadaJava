/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business;

import at.sks.scada.business.interfaces.MeasurementTypeServiceInterface;
import at.sks.scada.dal.DataAccessLayerException;
import at.sks.scada.dal.entities.MeasurementType;
import at.sks.scada.dal.repositories.interfaces.MeasurementTypeRepository;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author benny
 */
@Stateless
public class MeasurementTypeService{
    private static final Logger log = Logger.getLogger(CustomerService.class.getName());
    
     @EJB(beanName="MeasurementTypeRepository")    
    private MeasurementTypeRepository measurementTypeRepository;
       
    public MeasurementTypeService() {
        
    }
    
    public MeasurementTypeService(MeasurementTypeRepository mi) {
        this.measurementTypeRepository = mi;
    }
    
     public MeasurementType getMeasurementType(String measurementTypeId) throws BusinessLayerException {
        log.entering("MeasurementTypeService", "getMeasurementType");
        
        try {
            return measurementTypeRepository.get(measurementTypeId);
        } catch (DataAccessLayerException ex) {
            Logger.getLogger(MeasurementService.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            throw new BusinessLayerException(ex);
        }
    }
}
