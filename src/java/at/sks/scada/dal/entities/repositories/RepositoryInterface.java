/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.entities.repositories;

/**
 *
 * @author benny
 */
public interface RepositoryInterface<T> {
    public void add(T obj);
    public void update(T obj);
    public void delete(T obj);
    public void commitChanges();
    public T get(String id);
}
