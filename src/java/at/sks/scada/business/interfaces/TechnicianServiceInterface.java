/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business.interfaces;

/**
 *
 * @author benny
 */
public interface TechnicianServiceInterface {

    public at.sks.scada.dal.entities.Technician getTechnician(java.lang.String id) throws at.sks.scada.business.BusinessLayerException;

    public at.sks.scada.dal.entities.Person getPersonForTechnician(at.sks.scada.dal.entities.Technician t) throws at.sks.scada.business.BusinessLayerException;

}
