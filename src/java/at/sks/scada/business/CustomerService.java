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

/**
 *
 * @author patrick
 */
public class CustomerService {
    private static final Logger log = Logger.getLogger(CustomerService.class.getName());
    
    private RepositoryInterface<Customer> customerRepository;
    
    public CustomerService(RepositoryInterface<Customer> ri) {
        this.customerRepository = ri;
    }
    
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
