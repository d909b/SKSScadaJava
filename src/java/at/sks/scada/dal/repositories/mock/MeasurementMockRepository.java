/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.repositories.mock;

import at.sks.scada.dal.DataAccessLayerException;
import at.sks.scada.dal.entities.Measurement;
import at.sks.scada.dal.repositories.interfaces.MeasurementRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;

/**
 *
 * @author patrick
 */
@Mock
@Stateless
public class MeasurementMockRepository extends AbstractMockRepository<Measurement> implements MeasurementRepository {
    @Override
    public List<Measurement> findByNamedQueryWithParameters(String queryName, Map<String, Object> parameters) 
            throws DataAccessLayerException {
        if(queryName.equals("Measurement.findLatestBySiteID")) {
            Long siteID = (Long)parameters.get("siteID");
            
            List<Measurement> tmp = new ArrayList<Measurement>();
            for(Measurement m : table) {
                if(m.getSiteID() == siteID) {
                    tmp.add(m);
                }
            }
            
            if(tmp.isEmpty()) {
                return tmp;
            } else {                
                Measurement latest = tmp.get(0);
                for(Measurement m : tmp) {
                    if(m.getTime().after(latest.getTime())) {
                        latest = m;
                    }
                }
                
                List<Measurement> retVal = new ArrayList<Measurement>();
                retVal.add(latest);
                return retVal;
            }
        } else if(queryName.contains("Measurement.findBySiteID")) {
            Long siteID = (Long)parameters.get("siteID");
            
            List<Measurement> retVal = new ArrayList<Measurement>();
            for(Measurement m : table) {
                if(m.getSiteID() == siteID) {
                    retVal.add(m);
                }
            }
            
            return retVal;
        }
        
        throw new DataAccessLayerException("No such query exists.");
    }

    @Override
    public Measurement get(String id) throws DataAccessLayerException {
        for(Measurement m : table) {
            if(m.getMeasurementID() == Long.parseLong(id)) {
                return m;
            }
        }
        
        throw new DataAccessLayerException("No such element exists with ID: " + id + ".");
    }
}
