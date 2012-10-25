/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.entities.repositories;

import at.sks.scada.dal.entities.Measurement;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

/**
 *
 * @author benny
 */
@Stateless(name="dbRepo")
public class MeasurementDbRepository extends AbstractDbRepository<Measurement> implements RepositoryInterface<Measurement> {
    
    @Override
    public Measurement get(String id) throws NoResultException {
        return (Measurement) em.createNamedQuery("from Measurement where id = "+id).getSingleResult();
    }
}
