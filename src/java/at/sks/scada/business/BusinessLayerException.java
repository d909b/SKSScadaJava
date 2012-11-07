/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business;

/**
 *
 * @author patrick
 */
public class BusinessLayerException extends Exception {
    public BusinessLayerException() {
        
    }
    
    public BusinessLayerException(String msg){
        super(msg);
    }
    
    public BusinessLayerException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessLayerException(Throwable cause) {
        super(cause);
    }
}
