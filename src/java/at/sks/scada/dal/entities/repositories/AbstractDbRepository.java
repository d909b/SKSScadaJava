/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.entities.repositories;

import at.sks.scada.dal.entities.AbstractEntity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.RollbackException;

/**
 *
 * @author benny
 */
public abstract class AbstractDbRepository<T extends AbstractEntity> implements RepositoryInterface<T> {
    
    @PersistenceContext
    EntityManager em;   
    
    @Override
    public void add(T obj) {
       em.getTransaction().begin();
        em.persist(obj);
    }

    @Override
    public void update(T obj) {
        this.delete(obj);
        this.commitChanges();
        this.add(obj);
    }

    @Override
    public void delete(T obj) throws IllegalStateException{
        em.getTransaction().begin();
        em.remove(obj);
    }

    @Override
    public void commitChanges() throws IllegalStateException, RollbackException{
        em.getTransaction().commit();
    }

    @Override
    public T get(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
