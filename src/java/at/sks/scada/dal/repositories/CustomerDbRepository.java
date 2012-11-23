/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.repositories;

import at.sks.scada.dal.DataAccessLayerException;
import at.sks.scada.dal.entities.Customer;
import at.sks.scada.dal.repositories.interfaces.CustomerRepository;
import javax.ejb.Stateless;

/**
 *
 * @author benny
 */
@Stateless
public class CustomerDbRepository extends AbstractDbRepository<Customer> implements CustomerRepository {     
    
    @Override
    public Customer get(String id) throws DataAccessLayerException {
        try {
            return em.find(Customer.class,Long.parseLong(id));
        } catch(Exception ex) {
            throw new DataAccessLayerException(ex);
        }
    }
}
