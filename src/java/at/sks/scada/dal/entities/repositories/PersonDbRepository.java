/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.entities.repositories;

import at.sks.scada.dal.entities.Person;
import javax.persistence.NoResultException;

/**
 *
 * @author benny
 */
public class PersonDbRepository extends AbstractDbRepository<Person> implements RepositoryInterface<Person> {
    
    @Override
    public Person get(String id) throws NoResultException {
        return (Person) em.createNamedQuery("from Person where id = "+id).getSingleResult();
    }
}
