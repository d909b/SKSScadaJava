/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business.interfaces;

/**
 *
 * @author benny
 */
public interface SiteServiceInterface {

    public void addSite(at.sks.scada.dal.entities.Site site) throws at.sks.scada.business.BusinessLayerException;

    public java.util.List<at.sks.scada.dal.entities.Measurement> getLatestSiteState(at.sks.scada.dal.entities.Site site) throws at.sks.scada.business.BusinessLayerException;

    public java.util.List<at.sks.scada.dal.entities.Site> getSites(at.sks.scada.dal.entities.Customer customer) throws at.sks.scada.business.BusinessLayerException;

    public at.sks.scada.dal.entities.Site getSite(java.lang.String siteId) throws at.sks.scada.business.BusinessLayerException;

}
