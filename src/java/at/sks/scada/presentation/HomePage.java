/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.presentation;

import at.sks.scada.business.BusinessLayerException;
import at.sks.scada.business.CustomerService;
import at.sks.scada.business.SiteService;
import at.sks.scada.dal.entities.Customer;
import at.sks.scada.dal.entities.Site;
import com.sun.faces.context.flash.ELFlash;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author patrick
 */
@ManagedBean(name = "homePage")
@RequestScoped
public class HomePage implements Serializable {
    private List<Site> sitesModel;
    
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Site> getSitesModel() {        
        return sitesModel;
    }

    public void setSitesModel(List<Site> sitesModel) {
        this.sitesModel = sitesModel;
    }
    
    @EJB
    CustomerService customerService;
    
    @EJB
    SiteService siteService;
        
    /**
     * Creates a new instance of HomePage
     */
    public HomePage() {

    }
    
    @PostConstruct
    void init() {
        userId = (Long)ELFlash.getFlash().get("userId");
        
        Customer c = null;
        try {
            c = customerService.getCustomer(userId.toString());
        } catch (BusinessLayerException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<Site> sites = null;
        try {
            sites = siteService.getSites(c);
        } catch (BusinessLayerException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }

        sitesModel = sites;
    }
}
