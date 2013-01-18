/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.sks.scada.business.objects;

/**
 *
 * @author benny
 */
public class MeasurementObject {
    private String measurementType;
    private float wert;
    private String avgDay;
    private String avgMonth;
    private String avgYear;

    public void setAvgDay(String avgDay) {
        this.avgDay = avgDay;
    }

    public void setAvgMonth(String avgMonth) {
        this.avgMonth = avgMonth;
    }

    public void setAvgYear(String avgYear) {
        this.avgYear = avgYear;
    }

    public String getAvgDay() {
        return avgDay;
    }

    public String getAvgMonth() {
        return avgMonth;
    }

    public String getAvgYear() {
        return avgYear;
    }

    public String getMeasurementType() {
        return measurementType;
    }

    public float getWert() {
        return wert;
    }

    public void setMeasurementType(String measurementType) {
        this.measurementType = measurementType;
    }

    public void setWert(float wert) {
        this.wert = wert;
    }
    
    
}
