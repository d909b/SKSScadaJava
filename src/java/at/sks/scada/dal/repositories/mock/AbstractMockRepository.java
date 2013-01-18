/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.repositories.mock;

import at.sks.scada.dal.DataAccessLayerException;
import at.sks.scada.dal.entities.AbstractEntity;
import at.sks.scada.dal.repositories.interfaces.RepositoryInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author patrick
 */
public class AbstractMockRepository<T extends AbstractEntity> implements RepositoryInterface<T> {
    List<T> table = new ArrayList<T>();
    
    @Override
    public void add(T obj) throws DataAccessLayerException {
        table.add(obj);
    }

    @Override
    public void update(T obj) throws DataAccessLayerException {
        table.set(table.indexOf(obj), obj);
    }

    @Override
    public void delete(T obj) throws DataAccessLayerException {
        table.remove(obj);
    }

    @Override
    public List<T> findByNamedQuery(String queryName) throws DataAccessLayerException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<T> findByNamedQueryWithParameters(String queryName, Map<String, Object> parameters) throws DataAccessLayerException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public T get(String id) throws DataAccessLayerException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
