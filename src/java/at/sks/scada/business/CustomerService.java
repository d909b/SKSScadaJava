/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business;

import at.sks.scada.business.interfaces.CustomerServiceInterface;
import at.sks.scada.dal.DataAccessLayerException;
import at.sks.scada.dal.entities.Customer;
import at.sks.scada.dal.entities.Technician;
import at.sks.scada.dal.repositories.interfaces.CustomerRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author patrick
 */
@Stateless
public class CustomerService{
    private static final Logger log = Logger.getLogger(CustomerService.class.getName());
    
    @EJB(beanName="CustomerRepository")  
    private CustomerRepository customerRepository;
    
    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    public CustomerService() {
        
    }
    
    public CustomerService(CustomerRepository ri) {
        this.customerRepository = ri;
    }
    
    public void addCustomer(Customer customer) throws BusinessLayerException {
        log.entering("CustomerService", "addCustomer");
        
        Validator validator = factory.getValidator();
        
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        
        if(!violations.isEmpty()) {
            throw new BusinessLayerException("Passed an illegal customer object.");
        }
        
        try {
            customerRepository.add(customer);
        } catch (DataAccessLayerException ex) {
            log.log(Level.SEVERE, ex.getMessage(), ex);
            throw new BusinessLayerException(ex);
        }
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
    
    public Customer loginCustomer(String name, String password) throws BusinessLayerException, InvalidLoginException 
    {
        log.entering("CustomerService", "isValidCustomerLogin");
        try {
            Map<String,Object> parameters = new HashMap<String, Object>();
            
            parameters.put("name", name);
            parameters.put("password", password);
            
            List<Customer> customers = customerRepository
                    .findByNamedQueryWithParameters("Customer.findByNameAndPassword", parameters);
            
            if(customers.isEmpty())
            {
                throw new InvalidLoginException("The provided credentials were invalid.");
            }
            
            return customers.get(0);
        } catch (DataAccessLayerException ex) {
            log.log(Level.SEVERE, ex.getMessage(), ex);
            throw new BusinessLayerException(ex);
        }
    }
}
