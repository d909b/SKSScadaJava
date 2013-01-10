/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business;

import at.sks.scada.business.interfaces.StatisticsServiceInterface;
import at.sks.scada.dal.DataAccessLayerException;
import at.sks.scada.dal.entities.Customer;
import at.sks.scada.dal.entities.Measurement;
import at.sks.scada.dal.entities.Site;
import at.sks.scada.dal.repositories.interfaces.MeasurementRepository;
import at.sks.scada.dal.repositories.interfaces.SiteRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author patrick
 */
@Stateless
public class StatisticsService {
    private static final Logger log = Logger.getLogger(StatisticsService.class.getName());
    
    @Inject
    private MeasurementRepository measurementRepository;
    
    @Inject
    private SiteRepository siteRepository;

    public StatisticsService() {
    }
    
    public StatisticsService(MeasurementRepository measurementRepo,
            SiteRepository siteRepo) {
        this.measurementRepository = measurementRepo;
        siteRepository = siteRepo;
    }
    
    public List<Measurement> getCustomerStatistics(Customer customer) throws BusinessLayerException
    {
        log.entering("StatisticsService", "getCustomerStatistics");
        try {
            Map<String,Object> parameters = new HashMap<String, Object>();
            
            parameters.put("customerID", customer.getCustomerID());
            
            List<Site> sites = siteRepository.findByNamedQueryWithParameters("Site.findByCustomerID", parameters);
            
            List<Measurement> result = new ArrayList<Measurement>();
            for(Site s : sites) {
                parameters = new HashMap<String, Object>();
            
                parameters.put("siteID", s.getSiteID());
            
                List<Measurement> measurements =  measurementRepository
                        .findByNamedQueryWithParameters("Measurement.findBySiteID", parameters);
                
                result.addAll(measurements);
            }
            
            return result;
        } catch (DataAccessLayerException ex) {
            log.log(Level.SEVERE, ex.getMessage(), ex);
            throw new BusinessLayerException(ex);
        }
    }
}
