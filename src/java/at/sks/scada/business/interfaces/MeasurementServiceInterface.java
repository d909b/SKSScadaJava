/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business.interfaces;

/**
 *
 * @author benny
 */
public interface MeasurementServiceInterface {

    public java.util.List<at.sks.scada.dal.entities.Measurement> getAll() throws at.sks.scada.business.BusinessLayerException;

    public void createMeasurement(at.sks.scada.dal.entities.Measurement m) throws at.sks.scada.business.BusinessLayerException;

    public java.lang.String getAverageMeasurement(at.sks.scada.dal.entities.Measurement m, java.lang.String interval) throws at.sks.scada.business.BusinessLayerException;
}
