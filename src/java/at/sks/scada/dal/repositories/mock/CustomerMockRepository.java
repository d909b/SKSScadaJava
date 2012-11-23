/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.repositories.mock;

import at.sks.scada.dal.DataAccessLayerException;
import at.sks.scada.dal.entities.Customer;
import at.sks.scada.dal.repositories.interfaces.CustomerRepository;
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
public class CustomerMockRepository extends AbstractMockRepository<Customer> implements CustomerRepository {
    @Override
    public List<Customer> findByNamedQuery(String queryName) throws DataAccessLayerException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Customer> findByNamedQueryWithParameters(String queryName, Map<String, Object> parameters) throws DataAccessLayerException {
        if(queryName.equals("Customer.findByTechnicianID")) {
            Long technicianID = (Long)parameters.get("technicianID");
            
            List<Customer> retVal = new ArrayList<Customer>();
            for(Customer c : table) {
                if(c.getTechnicianID() == technicianID) {
                    retVal.add(c);
                }
            }
            
            return retVal;
        }
        
        throw new DataAccessLayerException("No such query exists.");
    }

    @Override
    public Customer get(String id) throws DataAccessLayerException {
        for(Customer c : table) {
            if(c.getCustomerID() == Long.parseLong(id)) {
                return c;
            }
        }
        
        throw new DataAccessLayerException("No such element exists with ID: " + id + ".");
    }
}
