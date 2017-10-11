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
public class Minute implements SetTimeSetter{
    
    /**
     * creates a minute object
     * @param min the value of minute
     */
    public Minute(int min) {
        this.minute = min;
    }
    
    /**
     * increases the minute appropriately on the clock
     */
    public void increase() {
        if (minute == MAX) {
            minute = 0;
        } else {
            minute++;
        }
    }
    
    /**
     * decreases the minute appropriately on the clock
     */
    public void decrease() {
        if (minute == 0) {
            minute = MAX;
        } else {
            minute--;
        }
    }
    
    /**
     * allows access to the minutes
     * @return the value of minute
     */
    public int get() {
        return minute;
    }
    
     /**
     * Methods that returns minutes in string form
     * @return minutes as a string
     */
    public String toString() {
        return "" + minute;
    }
    
    
    
    private int minute;
    final static int MAX = 59;
    
}
