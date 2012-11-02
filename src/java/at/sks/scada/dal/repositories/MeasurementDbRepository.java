/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.repositories;

import at.sks.scada.dal.entities.Measurement;
import javax.ejb.Stateless;

/**
 *
 * @author benny
 */
@Stateless(name="MeasurementDbRepo")
public class MeasurementDbRepository extends AbstractDbRepository<Measurement> implements RepositoryInterface<Measurement> {
    
     @Override
    public Measurement get(String id) throws IllegalStateException, IllegalArgumentException {
        return em.find(Measurement.class,Integer.parseInt(id));
    }
}
