/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business;

import at.sks.scada.dal.entities.Customer;
import at.sks.scada.dal.entities.Technician;
import java.util.List;
import java.util.logging.Logger;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author patrick
 */
public class CustomerService {
    private static final Logger log = Logger.getLogger(CustomerService.class.getName());
    
    public List<Customer> getCustomers(Technician technician) throws BusinessLayerException
    {
        throw new NotImplementedException();
    }
}
