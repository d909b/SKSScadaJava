/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.repositories;

import at.sks.scada.dal.DataAccessLayerException;
import at.sks.scada.dal.entities.AbstractEntity;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    
    @Override
    public List<T> findByNamedQuery(String queryName) throws DataAccessLayerException
    {
        try {
            return this.em.createNamedQuery(queryName).getResultList();
        } catch(Exception ex) {
            throw new DataAccessLayerException(ex);
        }
    }
    
    @Override
    public List<T> findByNamedQueryWithParameters(String queryName, 
        Map<String, Object> parameters) throws DataAccessLayerException
    {
        try {
            Query query = this.em.createNamedQuery(queryName);
            
            for(Map.Entry<String, Object> entry : parameters.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                
                query.setParameter(key, value);
            }
            
            return query.getResultList();
        } catch(Exception ex) {
            throw new DataAccessLayerException(ex);
        }
    }
}
