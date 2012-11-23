/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.repositories;

import at.sks.scada.dal.DataAccessLayerException;
import at.sks.scada.dal.entities.Technician;
import at.sks.scada.dal.repositories.interfaces.TechnicianRepository;
import javax.ejb.Stateless;

/**
 *
 * @author benny
 */
@Stateless
public class TechnicianDbRepository extends AbstractDbRepository<Technician> implements TechnicianRepository {
    
    @Override
    public Technician get(String id) throws DataAccessLayerException {
        try {
            return em.find(Technician.class,Long.parseLong(id));
        } catch(Exception ex) {
            throw new DataAccessLayerException(ex);
        }
    }
}
