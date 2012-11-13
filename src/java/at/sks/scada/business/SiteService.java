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
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author patrick
 */
public class SiteService {
    private static final Logger log = Logger.getLogger(SiteService.class.getName());
     
    private RepositoryInterface<Site> siteRepository;
    private RepositoryInterface<Measurement> measurementRepository;
    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

   public SiteService(RepositoryInterface<Site> siteRepo, RepositoryInterface<Measurement> measurementRepo) {
       this.siteRepository = siteRepo;
       this.measurementRepository = measurementRepo;
   }
    public Measurement getLatestSiteState(Site site) throws BusinessLayerException
    {
        log.entering("SiteService", "getLatestSiteState");
        
        Validator validator = factory.getValidator();
        
        Set<ConstraintViolation<Site>> violations = validator.validate(site);
        
        if(!violations.isEmpty()) {
            throw new BusinessLayerException("Passed an illegal technician object.");
        }
        
        try {
            Map<String,Object> parameters = new HashMap<String, Object>();
            
            parameters.put("siteID", site.getSiteID());
            
            List<Measurement> result = measurementRepository.findByNamedQueryWithParameters("Measurement.findLatestBySiteID", parameters);
            
            if(result.isEmpty()) {
                throw new BusinessLayerException("No measurements available for site with id " + site.getSiteID());
            }
            
            /** Return first. */
            return result.get(0);
        } catch (DataAccessLayerException ex) {
            log.log(Level.SEVERE, ex.getMessage(), ex);
            throw new BusinessLayerException(ex);
        }
    }
 
    public List<Site> getSites(Customer customer) throws BusinessLayerException
    {
        log.entering("SiteService", "getSites");
        
        Validator validator = factory.getValidator();
        
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        
        if(!violations.isEmpty()) {
            throw new BusinessLayerException("Passed an illegal technician object.");
        }
        
        try {
            Map<String,Object> parameters = new HashMap<String, Object>();
            
            parameters.put("customerID", customer.getCustomerID());
            
            List<Site> result = siteRepository.findByNamedQueryWithParameters("Site.findByCustomerID", parameters);
            
            return result;
        } catch (DataAccessLayerException ex) {
            log.log(Level.SEVERE, ex.getMessage(), ex);
            throw new BusinessLayerException(ex);
        }
    }
}
