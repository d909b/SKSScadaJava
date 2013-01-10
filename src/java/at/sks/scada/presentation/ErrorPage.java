/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.presentation;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author patrick
 */
@Named(value = "errorPage")
@RequestScoped
public class ErrorPage {
    private String errorType;

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }
    
    /**
     * Creates a new instance of ErrorPage
     */
    public ErrorPage() {
    }
}
