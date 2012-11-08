/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business;

import at.sks.scada.dal.DataAccessLayerException;
import at.sks.scada.dal.entities.Technician;
import at.sks.scada.dal.repositories.RepositoryInterface;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author benny
 */
public class TechnicianService {
    private static final Logger log = Logger.getLogger(CustomerService.class.getName());
    
    private RepositoryInterface<Technician> technicianRepository;
    
    public TechnicianService(RepositoryInterface<Technician> techRepo) {
        this.technicianRepository = techRepo;
    }
    
    public Technician getTechnician(String id) throws BusinessLayerException {
        log.entering("TechnicianService", "getTechnician");
        try {
            return technicianRepository.get(id);
        } catch (DataAccessLayerException ex) {
            log.log(Level.SEVERE, ex.getMessage(), ex);
            throw new BusinessLayerException(ex);
        }
    }
    
    public String getTechnicianLastName(Technician technician) throws BusinessLayerException {
        throw new NotImplementedException();
    }
}
