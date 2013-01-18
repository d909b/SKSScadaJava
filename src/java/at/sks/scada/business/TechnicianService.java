/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business;

import at.sks.scada.business.interfaces.TechnicianServiceInterface;
import at.sks.scada.dal.DataAccessLayerException;
import at.sks.scada.dal.entities.Person;
import at.sks.scada.dal.entities.Technician;
import at.sks.scada.dal.repositories.interfaces.PersonRepository;
import at.sks.scada.dal.repositories.interfaces.TechnicianRepository;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author benny
 */
@Stateless
public class TechnicianService{
    private static final Logger log = Logger.getLogger(CustomerService.class.getName());
    
    @Inject
    private TechnicianRepository technicianRepository;
    
    @Inject
    private PersonRepository personRepository;

    public TechnicianService() {
        
    }
    
    /**
     *  Constructor expects TechnicianDbRepository
     * @param techRepo
     */
    public TechnicianService(TechnicianRepository techRepo, PersonRepository personRepo) {
        this.technicianRepository = techRepo;
        this.personRepository = personRepo;
    }
    
    public Technician getTechnician(String id) throws BusinessLayerException {
        log.entering("TechnicianService", "getTechnician");
        try {
            Technician technician = technicianRepository.get(id);
            return technician;
        } catch (DataAccessLayerException ex) {
            log.log(Level.SEVERE, ex.getMessage(), ex);
            throw new BusinessLayerException(ex);
        }
    }
    
    public Person getPersonForTechnician(Technician t) throws BusinessLayerException {
        log.entering("TechnicianService", "getPersonForTechnician");
        try {
            return personRepository.get(String.valueOf(t.getPersonID()));
        } catch (DataAccessLayerException ex) {
            log.log(Level.SEVERE, ex.getMessage(), ex);
            throw new BusinessLayerException(ex);
        }
    }
}
