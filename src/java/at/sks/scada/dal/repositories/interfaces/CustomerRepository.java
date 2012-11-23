/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal.repositories.interfaces;

import at.sks.scada.dal.entities.Customer;
import at.sks.scada.dal.repositories.RepositoryInterface;

/**
 * NOTE: Those interfaces are necessary because generics cannot be injected.
 * @author patrick
 */
public interface CustomerRepository extends RepositoryInterface<Customer> {
    
}
