/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.repositories;

import at.sks.scada.dal.DataAccessLayerException;
import at.sks.scada.dal.entities.MeasurementType;
import at.sks.scada.dal.repositories.interfaces.MeasurementTypeRepository;
import javax.ejb.Stateless;

/**
 *
 * @author benny
 */
@Stateless
public class MeasurementTypeDbRepository extends AbstractDbRepository<MeasurementType> implements MeasurementTypeRepository {
        
    @Override
    public MeasurementType get(String id) throws DataAccessLayerException {
        try {
            return em.find(MeasurementType.class,Integer.parseInt(id));
        } catch(Exception ex) {
            throw new DataAccessLayerException(ex);
        }
    }
}
