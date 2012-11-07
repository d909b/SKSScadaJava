/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.repositories;

import at.sks.scada.dal.DataAccessLayerException;
import at.sks.scada.dal.entities.Person;
import javax.ejb.Stateless;

/**
 *
 * @author benny
 */
@Stateless(name="PersonDbRepo")
public class PersonDbRepository extends AbstractDbRepository<Person> implements RepositoryInterface<Person> {
    
     @Override
    public Person get(String id) throws DataAccessLayerException {
        try {
            return em.find(Person.class,Integer.parseInt(id));
        } catch(Exception ex) {
            throw new DataAccessLayerException(ex);
        }
    }
}
