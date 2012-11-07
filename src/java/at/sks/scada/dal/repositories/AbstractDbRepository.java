/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.repositories;

import at.sks.scada.dal.DataAccessLayerException;
import at.sks.scada.dal.entities.AbstractEntity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    public void add(T obj) throws DataAccessLayerException {
        try {
            em.persist(obj);
        } catch(Exception ex) {
            throw new DataAccessLayerException(ex);
        }
    }

    @Override
    public void update(T obj) throws DataAccessLayerException {
        throw new DataAccessLayerException(new UnsupportedOperationException("Not supported yet."));
    }

    @Override
    public void delete(String id) throws DataAccessLayerException {
        try {
            em.remove(get(id));
        } catch(Exception ex) {
            throw new DataAccessLayerException(ex);
        }
    }

    @Override
    public void commitChanges() throws DataAccessLayerException {
        try {
            em.flush();
        } catch(Exception ex) {
            throw new DataAccessLayerException(ex);
        }  
    }

    @Override
    public T get(String id) throws DataAccessLayerException {
        throw new DataAccessLayerException(new UnsupportedOperationException("Not supported yet."));
    }
}
