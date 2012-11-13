/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business;

import at.sks.scada.dal.DataAccessLayerException;
import at.sks.scada.dal.entities.Customer;
import at.sks.scada.dal.entities.Technician;
import at.sks.scada.dal.repositories.RepositoryInterface;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author patrick
 */
public class CustomerService {
    private static final Logger log = Logger.getLogger(CustomerService.class.getName());
    
    private RepositoryInterface<Customer> customerRepository;
    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    
    public CustomerService(RepositoryInterface<Customer> ri) {
        this.customerRepository = ri;
    }
    
    public List<Customer> getCustomers(Technician technician) throws BusinessLayerException
    {
        log.entering("CustomerService", "getCustomers");
        
        Validator validator = factory.getValidator();
        
        Set<ConstraintViolation<Technician>> violations = validator.validate(technician);
        
        if(!violations.isEmpty()) {
            throw new BusinessLayerException("Passed an illegal technician object.");
        }
        
        try {
            Map<String,Object> parameters = new HashMap<String, Object>();
            
            parameters.put("technicianID", technician.getTechnicianID());
            
            return customerRepository.findByNamedQueryWithParameters("Customer.findByTechnicianID", parameters);
        } catch (DataAccessLayerException ex) {
            log.log(Level.SEVERE, ex.getMessage(), ex);
            throw new BusinessLayerException(ex);
        }
    }
    
    public Customer getCustomer(String id) throws BusinessLayerException 
    {
        log.entering("CustomerService", "getCustomer");
        try {
            return customerRepository.get(id);
        } catch (DataAccessLayerException ex) {
            log.log(Level.SEVERE, ex.getMessage(), ex);
            throw new BusinessLayerException(ex);
        }
    }
}
