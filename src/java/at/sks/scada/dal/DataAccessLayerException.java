/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.dal;

/**
 *
 * @author patrick
 */
public class DataAccessLayerException extends Exception {
    public DataAccessLayerException() {
        
    }
    
    public DataAccessLayerException(String msg){
        super(msg);
    }
    
    public DataAccessLayerException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataAccessLayerException(Throwable cause) {
        super(cause);
    }
}
