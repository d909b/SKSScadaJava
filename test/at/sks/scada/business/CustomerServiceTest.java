/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business;

import at.sks.scada.dal.entities.Customer;
import at.sks.scada.dal.entities.Technician;
import at.sks.scada.dal.repositories.RepositoryInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author patrick
 */
public class CustomerServiceTest {
    
    private RepositoryInterface<Customer> customerRepository;
    
    ValidatorFactory factory;
    
    public CustomerServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        factory  = Validation.buildDefaultValidatorFactory();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCustomers method, of class CustomerService.
     */
    @Test
    public void testGetCustomers() throws Exception {
        /** TODO: Implement with MockRepository... DI needs to be fixed first. */
        System.out.println("getCustomers");
        Validator validator = factory.getValidator();
        
        Technician technician = new Technician(Long.valueOf("1"), Long.valueOf("3"));
        
        Customer c1 = new Customer(Long.valueOf("1"), Long.valueOf("1"), Long.valueOf("1"));
        Customer c2 = new Customer(Long.valueOf("2"), Long.valueOf("2"), Long.valueOf("1"));
        Customer c3 = new Customer(Long.valueOf("3"), Long.valueOf("6"), Long.valueOf("1"));
        List<Customer> expResult = new ArrayList<Customer>();
        expResult.add(c1);
        expResult.add(c2);
        expResult.add(c3);

        Set<ConstraintViolation<Customer>> violationsC1 = validator.validate(c1);
        Set<ConstraintViolation<Customer>> violationsC2 = validator.validate(c2);
        Set<ConstraintViolation<Customer>> violationsC3 = validator.validate(c3);
        Set<ConstraintViolation<Technician>> violationsT = validator.validate(technician);
        
        CustomerService instance = new CustomerService(customerRepository);
        
        List<Customer> result = instance.getCustomers(technician);
        assertEquals(0, violationsC1.size());
        assertEquals(0, violationsC2.size());
        assertEquals(0, violationsC3.size());
        assertEquals(0, violationsT.size());
        assertEquals(expResult, result);
    }
}
