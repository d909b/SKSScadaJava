/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.repositories;

import at.sks.scada.dal.DataAccessLayerException;
import at.sks.scada.dal.entities.Measurement;
import at.sks.scada.dal.repositories.interfaces.MeasurementRepository;
import javax.ejb.Stateless;

/**
 *
 * @author benny
 */
@Stateless(name="MeasurementRepository")
public class MeasurementDbRepository extends AbstractDbRepository<Measurement> implements MeasurementRepository {
    
     @Override
    public Measurement get(String id) throws DataAccessLayerException {
        try {
            return em.find(Measurement.class,Integer.parseInt(id));
        } catch(Exception ex) {
            throw new DataAccessLayerException(ex);
        }
    }
}
