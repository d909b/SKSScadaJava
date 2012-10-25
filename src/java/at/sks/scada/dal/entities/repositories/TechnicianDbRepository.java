/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.entities.repositories;

import at.sks.scada.dal.entities.Technician;
import javax.persistence.NoResultException;

/**
 *
 * @author benny
 */
public class TechnicianDbRepository extends AbstractDbRepository<Technician> implements RepositoryInterface<Technician> {
    
    @Override
    public Technician get(String id) throws NoResultException {
        return (Technician) em.createNamedQuery("from Technician where id = "+id).getSingleResult();
    }
}
