/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business;

import at.sks.scada.dal.DataAccessLayerException;
import at.sks.scada.dal.entities.Customer;
import at.sks.scada.dal.entities.Measurement;
import at.sks.scada.dal.repositories.RepositoryInterface;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author patrick
 */
public class StatisticsService {
    private static final Logger log = Logger.getLogger(StatisticsService.class.getName());
    private SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    private RepositoryInterface<Measurement> measurementRepository;
    
    public StatisticsService(RepositoryInterface<Measurement> measurementRepo) {
        this.measurementRepository = measurementRepo;
    }
    
    public List<Measurement> getCustomerStatistics(Customer customer,
            Date startDate, Date endDate) throws BusinessLayerException
    {
       log.entering("StatisticsService", "getCustomerStatistics");
        try {
            String start = sdf.format(startDate);
            String end = sdf.format(endDate);
            
            //not sql injection save
            List<Measurement> result = 
                    measurementRepository.findByNamedQuery("from Measurement"
                                                                + " where customerID = " + customer.getCustomerID()
                                                                + " and time > " + start
                                                                + " and time < " + end
                                                                + "order by time");
            if(result.isEmpty()) {
                throw new BusinessLayerException("No statistic available for customer with id " + customer.getCustomerID());
            }
            
            return result;
        } catch (DataAccessLayerException ex) {
            log.log(Level.SEVERE, ex.getMessage(), ex);
            throw new BusinessLayerException(ex);
        }
    }
}
