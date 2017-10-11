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
public class Second implements SetTimeSetter{
    
    /**
     * creates a second object
     * @param second the value of minute
     */
    public Second(int second) {
        this.second = second;
    }
    
    /**
     * increases the second appropriately on the clock
     */
    public void increase() {
        if (second == MAX) {
            second = 0;
        } else {
            second++;
        }
    }
    
    /**
     * decreases the second appropriately on the clock
     */
    public void decrease() {
        if (second == 0) {
            second = MAX;
        } else {
            second--;
        }
    }
    
    /**
     * allows access to the seconds
     * @return the value of minute
     */
    public int get() {
        return second;
    }
    
    /**
     * Methods that returns seconds in string form
     * @return seconds as a string
     */
    public String toString() {
        return "" + second;
    }
    
    
    
    private int second;
    final static int MAX = 59;
    
    
}
