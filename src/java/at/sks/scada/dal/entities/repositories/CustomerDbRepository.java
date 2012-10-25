/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.entities.repositories;

import at.sks.scada.dal.entities.Customer;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

/**
 *
 * @author benny
 */
@Stateless(name="dbRepo")
public class CustomerDbRepository extends AbstractDbRepository<Customer> implements RepositoryInterface<Customer> {     
    
    @Override
    public Customer get(String id) throws NoResultException {
        return (Customer) em.createNamedQuery("from Customer where id = "+id).getSingleResult();
    }
}
