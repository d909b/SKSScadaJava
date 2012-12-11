/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.services.service;

import at.sks.scada.business.BusinessLayerException;
import at.sks.scada.business.CustomerService;
import at.sks.scada.business.SiteService;
import at.sks.scada.dal.entities.Customer;
import at.sks.scada.dal.entities.Site;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author patrick
 */
@WebService(serviceName = "RegistrationService")
@Stateless()
public class RegistrationSOAPFacade {
    private static final Logger log = Logger.getLogger(RegistrationSOAPFacade.class.getName());
    
    @EJB
    CustomerService customerService;
    
    @EJB
    SiteService siteService;
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "registerCustomer")
    public void registerCustomer(@WebParam(name = "customer") Customer customer) throws ServicesLayerException {
        log.entering("RegistrationSOAPFacade", "registerCustomer");
        try {
            customerService.addCustomer(customer);
        } catch (BusinessLayerException ex) {
            Logger.getLogger(RegistrationSOAPFacade.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServicesLayerException(ex);
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "registerSite")
    public void registerSite(@WebParam(name = "site") Site site) throws ServicesLayerException {
        log.entering("RegistrationSOAPFacade", "registerSite");
        try {
            siteService.addSite(site);
        } catch (BusinessLayerException ex) {
            Logger.getLogger(RegistrationSOAPFacade.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServicesLayerException(ex);
        }
    }   
}
