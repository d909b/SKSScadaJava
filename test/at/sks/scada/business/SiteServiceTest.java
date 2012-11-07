/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business;

import at.sks.scada.dal.entities.Customer;
import at.sks.scada.dal.entities.Measurement;
import at.sks.scada.dal.entities.Site;
import java.util.List;
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getLatestSiteState method, of class SiteService.
     */
    @Test
    public void testGetLatestSiteState() throws Exception {
        System.out.println("getLatestSiteState");
        Site site = null;
        SiteService instance = new SiteService();
        Measurement expResult = null;
        Measurement result = instance.getLatestSiteState(site);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSites method, of class SiteService.
     */
    @Test
    public void testGetSites() throws Exception {
        System.out.println("getSites");
        Customer customer = null;
        SiteService instance = new SiteService();
        List expResult = null;
        List result = instance.getSites(customer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
