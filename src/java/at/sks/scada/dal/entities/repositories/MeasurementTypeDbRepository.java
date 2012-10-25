/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.entities.repositories;

import at.sks.scada.dal.entities.MeasurementType;
import javax.persistence.NoResultException;

/**
 *
 * @author benny
 */
public class MeasurementTypeDbRepository extends AbstractDbRepository<MeasurementType> implements RepositoryInterface<MeasurementType> {
        
    @Override
    public MeasurementType get(String id) throws NoResultException {
        return (MeasurementType) em.createNamedQuery("from MeasurementType where id = "+id).getSingleResult();
    }
}
