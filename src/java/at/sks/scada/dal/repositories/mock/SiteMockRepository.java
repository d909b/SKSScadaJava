/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.repositories.mock;

import at.sks.scada.dal.DataAccessLayerException;
import at.sks.scada.dal.entities.Site;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author patrick
 */
public class SiteMockRepository extends AbstractMockRepository<Site> {
    @Override
    public List<Site> findByNamedQuery(String queryName) throws DataAccessLayerException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Site> findByNamedQueryWithParameters(String queryName, Map<String, Object> parameters) 
            throws DataAccessLayerException {
        if(queryName.equals("Site.findByCustomerID")) {
            Long customerID = (Long)parameters.get("customerID");
            
            List<Site> retVal = new ArrayList<Site>();
            for(Site s : table) {
                if(s.getSiteID() == customerID) {
                    retVal.add(s);
                }
            }
            
            return retVal;
        }
        
        throw new DataAccessLayerException("No such query exists.");
    }

    @Override
    public Site get(String id) throws DataAccessLayerException {
        for(Site s : table) {
            if(s.getSiteID() == Long.parseLong(id)) {
                return s;
            }
        }
        
        throw new DataAccessLayerException("No such element exists with ID: " + id + ".");
    }
}
