/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business.interfaces;

/**
 *
 * @author benny
 */
public interface StatisticsServiceInterface {

    public java.util.List<at.sks.scada.dal.entities.Measurement> getCustomerStatistics(at.sks.scada.dal.entities.Customer customer) throws at.sks.scada.business.BusinessLayerException;
    
}
