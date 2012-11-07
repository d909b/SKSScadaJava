/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business;

import at.sks.scada.dal.entities.Customer;
import at.sks.scada.dal.entities.Measurement;
import at.sks.scada.dal.entities.Site;
import java.util.List;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author patrick
 */
public class SiteService {
    public Measurement getLatestSiteState(Site site)
    {
        throw new NotImplementedException();
    }
 
    public List<Site> getSites(Customer customer)
    {
        throw new NotImplementedException();
    }
}
