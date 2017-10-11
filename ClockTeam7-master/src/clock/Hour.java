/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

/**
 *
 * @author trparsonsgrayson
 */
public class Hour implements SetTimeSetter{ 
    
    /**
     * creates a hour object
     * @param hour the value of minute
     */
    public Hour(int hour) {
        this.hour = hour;
    }
    
    /**
     * increases the hour appropriately on the clock
     */
    public void increase() {
        if (hour == MAX) {
            hour = 0;
        } else {
            hour++;
        }
    }
    
    /**
     * decreases the hour appropriately on the clock
     */
    public void decrease() {
        if (hour == 0) {
            hour = MAX;
        } else {
            hour--;
        }
    }
    
    /**
     * allows access to the hours
     * @return the value of minute
     */
    public int get() {
        return hour;
    }
    
    /**
     * Methods that returns hours in string form
     * @return hours as a string
     */
    public String toString() {
        return "" + hour;
    }
    
    
    
    private int hour;
    final static int MAX = 23;
    
}
