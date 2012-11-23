/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business;

import at.sks.scada.dal.entities.Customer;
import at.sks.scada.dal.entities.Measurement;
import at.sks.scada.dal.entities.Site;
import at.sks.scada.dal.repositories.RepositoryInterface;
import at.sks.scada.dal.repositories.interfaces.MeasurementRepository;
import at.sks.scada.dal.repositories.interfaces.SiteRepository;
import at.sks.scada.dal.repositories.mock.MeasurementMockRepository;
import at.sks.scada.dal.repositories.mock.SiteMockRepository;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author benny
 */
public class StatisticsServiceTest {

    private MeasurementRepository measurementRepository;
    private SiteRepository siteRepository;
    
    ValidatorFactory factory;
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        factory  = Validation.buildDefaultValidatorFactory();
        measurementRepository = new MeasurementMockRepository();
        siteRepository = new SiteMockRepository();
    }

    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testGetCustomerStatistics() throws Exception {
        Validator validator = factory.getValidator();
        
        Date now = new Date();
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -5);
        Date startDate = new Date(cal.getTimeInMillis());
        
        cal.add(Calendar.DAY_OF_MONTH, 10);
        Date endDate = new Date(cal.getTimeInMillis());
        
        Customer customer = new Customer(Long.valueOf("1"), Long.valueOf("1"), 
                Long.valueOf("1"));
        
        Site site = new Site(Long.parseLong("1"), "description hsda", 
                Float.parseFloat("123.0"), Float.parseFloat("123.0"), 
                "123A", Long.parseLong("1"));
        
        siteRepository.add(site);
        
        Measurement m1 = new Measurement(Long.parseLong("1"), Float.parseFloat("10"),
                now, Long.parseLong("1"), Long.parseLong("1"));
        
        Measurement m2 = new Measurement(Long.parseLong("2"), Float.parseFloat("100"),
                now, Long.parseLong("1"), Long.parseLong("4"));
        
        List<Measurement> expResult = new ArrayList<Measurement>();
        expResult.add(m1);
        expResult.add(m2);
        
        measurementRepository.add(m1);
        measurementRepository.add(m2);
        
        Set<ConstraintViolation<Customer>> violationsC = validator.validate(customer);
        Set<ConstraintViolation<Measurement>> violationsM1 = validator.validate(m1);
        Set<ConstraintViolation<Measurement>> violationsM2 = validator.validate(m2);
        
        StatisticsService ss = new StatisticsService(measurementRepository, siteRepository);
        List<Measurement> result = ss.getCustomerStatistics(customer);
        assertEquals(0, violationsC.size());
        assertEquals(0, violationsM1.size());
        assertEquals(0, violationsM2.size());
        assertEquals(expResult, result);
    }
}
