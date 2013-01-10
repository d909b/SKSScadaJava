/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business.interfaces;

/**
 *
 * @author benny
 */
public interface MeasurementTypeServiceInterface {

    public at.sks.scada.dal.entities.MeasurementType getMeasurementType(java.lang.String measurementTypeId) throws at.sks.scada.business.BusinessLayerException;
    
}
