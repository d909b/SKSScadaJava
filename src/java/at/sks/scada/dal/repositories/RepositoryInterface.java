/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.repositories;

/**
 *
 * @author benny
 */
public interface RepositoryInterface<T> {
    public void add(T obj);
    public void update(T obj);
    public void delete(String id);
    public void commitChanges();
    public T get(String id);
}
