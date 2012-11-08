/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business;

import at.sks.scada.dal.entities.Customer;
import at.sks.scada.dal.entities.Technician;
import at.sks.scada.dal.repositories.RepositoryInterface;
import java.util.List;
import javax.ejb.EJB;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author patrick
 */
public class CustomerServiceTest {
    
    @EJB(beanName = "CustomerDbRepo")
    private RepositoryInterface<Customer> customerRepository;
    
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
        Technician technician = null;
        CustomerService instance = new CustomerService(customerRepository);
        List expResult = null;
        List result = instance.getCustomers(technician);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
