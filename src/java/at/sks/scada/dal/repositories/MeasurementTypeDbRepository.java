/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.repositories;

import at.sks.scada.dal.entities.MeasurementType;
import javax.ejb.Stateless;
import javax.persistence.TransactionRequiredException;

/**
 *
 * @author benny
 */
@Stateless(name="MeasurementTypeDbRepo")
public class MeasurementTypeDbRepository extends AbstractDbRepository<MeasurementType> implements RepositoryInterface<MeasurementType> {
        
    @Override
    public MeasurementType get(String id) throws IllegalStateException, IllegalArgumentException {
        return em.find(MeasurementType.class,Integer.parseInt(id));
    }
}
