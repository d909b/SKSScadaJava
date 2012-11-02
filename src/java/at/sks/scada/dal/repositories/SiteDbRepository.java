/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.repositories;

import at.sks.scada.dal.entities.Site;
import javax.ejb.Stateless;

/**
 *
 * @author benny
 */
@Stateless(name="SiteDbRepo")
public class SiteDbRepository extends AbstractDbRepository<Site> implements RepositoryInterface<Site> {
    
     @Override
    public Site get(String id) throws IllegalStateException, IllegalArgumentException {
        return em.find(Site.class,Integer.parseInt(id));
    }
}
