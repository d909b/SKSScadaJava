/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.repositories;

import at.sks.scada.dal.DataAccessLayerException;
import java.util.List;

/**
 *
 * @author benny
 */
public interface RepositoryInterface<T> {
    public void add(T obj) throws DataAccessLayerException;
    public void update(T obj) throws DataAccessLayerException;
    public void delete(String id) throws DataAccessLayerException;
    public void commitChanges() throws DataAccessLayerException;
    public T get(String id) throws DataAccessLayerException;
    public List<T> findByNamedQuery(String queryName) throws DataAccessLayerException;
}
