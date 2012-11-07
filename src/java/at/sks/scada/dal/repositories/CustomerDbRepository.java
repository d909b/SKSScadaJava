/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.repositories;

import at.sks.scada.dal.DataAccessLayerException;
import at.sks.scada.dal.entities.Customer;
import javax.ejb.Stateless;

/**
 *
 * @author benny
 */
@Stateless(name="CustomerDbRepo")
public class CustomerDbRepository extends AbstractDbRepository<Customer> implements RepositoryInterface<Customer> {     
    
    @Override
    public Customer get(String id) throws DataAccessLayerException {
        try {
            return em.find(Customer.class,Integer.parseInt(id));
        } catch(Exception ex) {
            throw new DataAccessLayerException(ex);
        }
    }
}
