/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.entities.repositories;

import at.sks.scada.dal.entities.Site;
import javax.persistence.NoResultException;

/**
 *
 * @author benny
 */
public class SiteDbRepository extends AbstractDbRepository<Site> implements RepositoryInterface<Site> {
    
    @Override
    public Site get(String id) throws NoResultException {
        return (Site) em.createNamedQuery("from Site where id = "+id).getSingleResult();
    }
}
