/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business;

import at.sks.scada.dal.entities.Customer;
import at.sks.scada.dal.entities.Measurement;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author patrick
 */
public class StatisticsService {
    private static final Logger log = Logger.getLogger(StatisticsService.class.getName());
    
    public List<Measurement> getCustomerStatistics(Customer customer,
            Date startDate, Date endDate) throws BusinessLayerException
    {
       throw new NotImplementedException(); 
    }
}
