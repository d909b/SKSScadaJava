/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.repositories;

import at.sks.scada.dal.entities.Technician;
import javax.ejb.Stateless;

/**
 *
 * @author benny
 */
@Stateless(name="TechnicianDbRepo")
public class TechnicianDbRepository extends AbstractDbRepository<Technician> implements RepositoryInterface<Technician> {
    
     @Override
    public Technician get(String id) throws IllegalStateException, IllegalArgumentException {
        return em.find(Technician.class,Integer.parseInt(id));
    }
}
