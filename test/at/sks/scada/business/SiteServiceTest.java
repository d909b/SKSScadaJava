/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business;

import at.sks.scada.dal.entities.Customer;
import at.sks.scada.dal.entities.Measurement;
import at.sks.scada.dal.entities.Site;
import at.sks.scada.dal.entities.Technician;
import at.sks.scada.dal.repositories.RepositoryInterface;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
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
public class SiteServiceTest {
    
    private RepositoryInterface<Customer> customerRepository;
    private RepositoryInterface<Technician> technicianRepo;
    private RepositoryInterface<Site> siteRepo;
    private RepositoryInterface<Measurement> measurementRepo;
    
    ValidatorFactory factory;
    
    public SiteServiceTest() {
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
     * Test of getLatestSiteState method, of class SiteService.
     */
    @Test
    public void testGetLatestSiteState() throws Exception {
         /** TODO: Implement with MockRepository... DI needs to be fixed first. */
        System.out.println("getLatestSiteState");
        Validator validator = factory.getValidator();
        Date now = new Date();
        
        Site site = new Site(Long.parseLong("1"), "description hsda", Float.parseFloat("123.0"), Float.parseFloat("123.0"), "123A", Long.parseLong("1"));
        Measurement m1 = new Measurement(Long.parseLong("1"), Float.parseFloat("10"), now, Long.parseLong("1"), Long.parseLong("1"));
        Measurement m2 = new Measurement(Long.parseLong("2"), Float.parseFloat("100"), now, Long.parseLong("1"), Long.parseLong("4"));
        List<Measurement> expResult = new ArrayList<Measurement>();
        expResult.add(m1);
        expResult.add(m2);
        
        Set<ConstraintViolation<Measurement>> violationsM1 = validator.validate(m1);
        Set<ConstraintViolation<Measurement>> violationsM2 = validator.validate(m2);
        Set<ConstraintViolation<Site>> violationsS = validator.validate(site);
        
        SiteService instance = new SiteService(siteRepo, measurementRepo);
        
        List<Measurement> result = instance.getLatestSiteState(site);
        assertEquals(0, violationsM1.size());
        assertEquals(0, violationsM2.size());
        assertEquals(0, violationsS.size());
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getSites method, of class SiteService.
     */
    @Test
    public void testGetSites() throws Exception {
        System.out.println("getSites");
        Validator validator = factory.getValidator();
        Customer customer = new Customer(Long.parseLong("1"), Long.parseLong("1"), Long.parseLong("1"));
        Site s1 = new Site(Long.parseLong("1"), "description hsda", Float.parseFloat("123.0"), Float.parseFloat("123.0"), "123A", Long.parseLong("1"));
        List<Site> expResult = new ArrayList<Site>();
        expResult.add(s1);
        
        Set<ConstraintViolation<Site>> violationsS1 = validator.validate(s1);
        Set<ConstraintViolation<Customer>> violationsC = validator.validate(customer);
        
        SiteService instance = new SiteService(siteRepo, measurementRepo);

        List<Site> result = instance.getSites(customer);
        assertEquals(0, violationsS1.size());
        assertEquals(0, violationsC.size());
        assertEquals(expResult, result);
    }
}
