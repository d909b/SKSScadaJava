/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.repositories;

import at.sks.scada.dal.DataAccessLayerException;
import at.sks.scada.dal.entities.Site;
import at.sks.scada.dal.repositories.interfaces.SiteRepository;
import javax.ejb.Stateless;

/**
 *
 * @author benny
 */
@Stateless
public class SiteDbRepository extends AbstractDbRepository<Site> implements SiteRepository {
    
     @Override
    public Site get(String id) throws DataAccessLayerException {
        try {
            return em.find(Site.class,Integer.parseInt(id));
        } catch(Exception ex) {
            throw new DataAccessLayerException(ex);
        }
    }
}
