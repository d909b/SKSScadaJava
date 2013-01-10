/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.presentation;

import at.sks.scada.business.BusinessLayerException;
import at.sks.scada.business.CustomerService;
import at.sks.scada.business.InvalidLoginException;
import at.sks.scada.dal.entities.Customer;
import com.sun.faces.context.flash.ELFlash;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author patrick
 */
@ManagedBean(name = "loginPage")
@RequestScoped
public class LoginPage implements Serializable {
    private static final Logger log = Logger.getLogger(LoginPage.class.getName());
    
    @EJB
    CustomerService customerService;
    
    private String name;
    private String password;
    
    private Long userId;    
    
    private String errorType;

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Creates a new instance of LoginPage
     */
    public LoginPage() {
    }
    
    public String login() {
        log.entering("LoginManager", "login");
        String errorPage = "error";
        String homePage = "home";
        try {
            Customer customer = customerService.loginCustomer(name, password);
            
            userId = customer.getCustomerID();
            
            ELFlash.getFlash().put("userId", userId);
            
            return homePage;
        } catch (InvalidLoginException ex) {
            log.log(Level.SEVERE, null, ex);
            
            errorType = ex.getMessage();
            
            return errorPage;
        } catch (BusinessLayerException ex) {
            log.log(Level.SEVERE, null, ex);
            
            errorType = ex.getMessage();
            
            return errorPage;
        }
    }
}
