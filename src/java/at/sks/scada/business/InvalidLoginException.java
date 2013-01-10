/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business;

/**
 *
 * @author patrick
 */
public class InvalidLoginException  extends Exception {
    public InvalidLoginException() {
        
    }
    
    public InvalidLoginException(String msg){
        super(msg);
    }
    
    public InvalidLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidLoginException(Throwable cause) {
        super(cause);
    }
}
