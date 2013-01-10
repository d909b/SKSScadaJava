/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business.interfaces;

import at.sks.scada.business.BusinessLayerException;
import at.sks.scada.business.InvalidLoginException;
import at.sks.scada.dal.entities.Customer;
import at.sks.scada.dal.entities.Technician;
import java.util.List;

/**
 *
 * @author benny
 */
public interface CustomerServiceInterface {
    public void addCustomer(Customer customer) throws BusinessLayerException;
     public List<Customer> getCustomers(Technician technician) throws BusinessLayerException;
     public Customer getCustomer(String id) throws BusinessLayerException;
     public Customer loginCustomer(String name, String password) throws BusinessLayerException, InvalidLoginException;
}
