/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.services.service;

/**
 *
 * @author patrick
 */
public class ServicesLayerException extends Exception {
    public ServicesLayerException() {
        
    }
    
    public ServicesLayerException(String msg){
        super(msg);
    }
    
    public ServicesLayerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServicesLayerException(Throwable cause) {
        super(cause);
    }
}
