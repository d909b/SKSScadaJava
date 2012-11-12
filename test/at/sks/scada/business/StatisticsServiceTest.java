/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business;

import at.sks.scada.dal.entities.Customer;
import at.sks.scada.dal.entities.Measurement;
import at.sks.scada.dal.repositories.RepositoryInterface;
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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author benny
 */
public class StatisticsServiceTest {

    private RepositoryInterface<Measurement> measurementRepository;
    
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
    }

    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testGetCustomerStatistics() throws Exception {
         /** TODO: Implement with MockRepository... DI needs to be fixed first. */
        System.out.println("getCustomerStatistics");
        Validator validator = factory.getValidator();
        
        Date now = new Date();
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -5);
        Date startDate = new Date(cal.getTimeInMillis());
        cal.add(Calendar.DAY_OF_MONTH, 10);
        Date endDate = new Date(cal.getTimeInMillis());
        Customer customer = new Customer(Long.valueOf("1"), Long.valueOf("1"), Long.valueOf("1"));
        Measurement m1 = new Measurement(Long.parseLong("1"), Float.parseFloat("10"), now, Long.parseLong("1"), Long.parseLong("1"));
        Measurement m2 = new Measurement(Long.parseLong("2"), Float.parseFloat("100"), now, Long.parseLong("1"), Long.parseLong("4"));
        List<Measurement> expResult = new ArrayList<Measurement>();
        expResult.add(m1);
        expResult.add(m2);
        
        Set<ConstraintViolation<Customer>> violationsC = validator.validate(customer);
        Set<ConstraintViolation<Measurement>> violationsM1 = validator.validate(m1);
        Set<ConstraintViolation<Measurement>> violationsM2 = validator.validate(m2);
        
        StatisticsService ss = new StatisticsService(measurementRepository);
        List<Measurement> result = ss.getCustomerStatistics(customer, startDate, endDate);
        assertEquals(0, violationsC.size());
        assertEquals(0, violationsM1.size());
        assertEquals(0, violationsM2.size());
        assertEquals(expResult, result);
    }
}
