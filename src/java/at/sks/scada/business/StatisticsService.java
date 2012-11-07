/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business;

import at.sks.scada.dal.entities.Customer;
import at.sks.scada.dal.entities.Measurement;
import at.sks.scada.dal.entities.Site;
import at.sks.scada.dal.repositories.RepositoryInterface;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.inject.Inject;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author patrick
 */
public class StatisticsService {
    private static final Logger log = Logger.getLogger(StatisticsService.class.getName());
    
    @Inject
    private RepositoryInterface<Measurement> measurementRepository;
    
    public List<Measurement> getCustomerStatistics(Customer customer,
            Date startDate, Date endDate) throws BusinessLayerException
    {
       throw new NotImplementedException(); 
    }
}
