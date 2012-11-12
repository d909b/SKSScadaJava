/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business;

import at.sks.scada.dal.DataAccessLayerException;
import at.sks.scada.dal.entities.Customer;
import at.sks.scada.dal.entities.Measurement;
import at.sks.scada.dal.repositories.RepositoryInterface;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    
    //not working with timerange. returns all statistics for the site
    public List<Measurement> getCustomerStatistics(Customer customer,
            Date startDate, Date endDate) throws BusinessLayerException
    {
       log.entering("StatisticsService", "getCustomerStatistics");
        try {
            Map<String,Object> parameters = new HashMap<String, Object>();
            
            parameters.put("customerID", customer.getCustomerID());
            //parameters.put("startTime", startDate);
            //parameters.put("endTime", endDate);
            
            List<Measurement> result =  measurementRepository.findByNamedQueryWithParameters("Measurement.findByCustomerAndByTimerange", parameters);
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
