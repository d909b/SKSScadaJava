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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author patrick
 */
public class CustomerService {
    private static final Logger log = Logger.getLogger(CustomerService.class.getName());
    
    @Inject
    RepositoryInterface<Customer> customerRepository;
    
    public List<Customer> getCustomers(Technician technician) throws BusinessLayerException
    {
        log.entering("CustomerService", "getCustomers");
        
        try {
            Map<String,Object> parameters = new HashMap<String, Object>();
            
            parameters.put("technicianID", technician.getTechnicianID());
            
            return customerRepository.findByNamedQueryWithParameters("Customer.findByTechnicianID", parameters);
        } catch (DataAccessLayerException ex) {
            log.log(Level.SEVERE, ex.getMessage(), ex);
            throw new BusinessLayerException(ex);
        }
    }
}
