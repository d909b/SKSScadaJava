/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business;

import at.sks.scada.dal.DataAccessLayerException;
import at.sks.scada.dal.entities.Customer;
import at.sks.scada.dal.entities.Measurement;
import at.sks.scada.dal.entities.Site;
import at.sks.scada.dal.repositories.RepositoryInterface;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author patrick
 */
public class SiteService {
    private static final Logger log = Logger.getLogger(SiteService.class.getName());
     
    private RepositoryInterface<Site> siteRepository;
    private RepositoryInterface<Measurement> measurementRepository;

   public SiteService(RepositoryInterface<Site> siteRepo, RepositoryInterface<Measurement> measurementRepo) {
       this.siteRepository = siteRepo;
       this.measurementRepository = measurementRepo;
   }
    public List<Measurement> getLatestSiteState(Site site) throws BusinessLayerException
    {
        log.entering("SiteService", "getLatestSiteState");
        try {
            Map<String,Object> parameters = new HashMap<String, Object>();
            
            parameters.put("siteID", site.getSiteID());
            
            List<Measurement> result = measurementRepository.findByNamedQueryWithParameters("Measurement.findLatestBySiteID", parameters);
            
            if(result.isEmpty()) {
                throw new BusinessLayerException("No measurements available for site with id " + site.getSiteID());
            }
            
            /** Return first. */
            return result;
        } catch (DataAccessLayerException ex) {
            log.log(Level.SEVERE, ex.getMessage(), ex);
            throw new BusinessLayerException(ex);
        }
    }
 
    public List<Site> getSites(Customer customer) throws BusinessLayerException
    {
         log.entering("SiteService", "getSites");
        try {
            Map<String,Object> parameters = new HashMap<String, Object>();
            
            parameters.put("customerID", customer.getCustomerID());
            
            List<Site> result = siteRepository.findByNamedQueryWithParameters("Site.findByCustomerID", parameters);
            
            if(result.isEmpty()) {
                throw new BusinessLayerException("No sites available for customer with id " + customer.getCustomerID());
            }
            
            return result;
        } catch (DataAccessLayerException ex) {
            log.log(Level.SEVERE, ex.getMessage(), ex);
            throw new BusinessLayerException(ex);
        }
    }
}
