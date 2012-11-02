/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.repositories;

import at.sks.scada.dal.entities.AbstractEntity;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;

/**
 *
 * @author benny
 */
public abstract class AbstractDbRepository<T extends AbstractEntity> implements RepositoryInterface<T> {

    @PersistenceContext
    EntityManager em;   
    
    public AbstractDbRepository() {
    }
    
    @Override
    public void add(T obj) throws EntityExistsException, IllegalStateException, IllegalArgumentException, TransactionRequiredException {
        em.persist(obj);
    }

    @Override
    public void update(T obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(String id) throws IllegalStateException, IllegalArgumentException, TransactionRequiredException{
        em.remove(get(id));
    }

    @Override
    public void commitChanges() throws IllegalStateException, TransactionRequiredException, PersistenceException{
        em.flush();
    }

    @Override
    public T get(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
