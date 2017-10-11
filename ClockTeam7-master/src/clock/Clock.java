/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import java.awt.event.*;
import javax.swing.Timer;

public class Clock {

    /**
     * A constructor for the Clock class
     *
     * @param hour an integer 0-23
     * @param min an integer 0-59
     * @param second an integer 0-59
     */
    public Clock(int hour, int min, int second) {
        this.hour = new Hour(hour);
        this.min = new Minute(min);
        this.second = new Second(second);
        this.shouldTick = true;
        this.state = States.NOTHING;
    }
    
    /**
     * function that returns value of hour
     * @return the hour value
     */
    public int getHour() {
        return hour.get();
    }
    
    /**
     * function that returns value of min
     * @return the min value
     */
    public int getMinute() {
        return min.get();
    }
    
    /**
     * function that returns value of second
     * @return the second value
     */
    public int getSeconds() {
        return second.get();
    }
    /**
     * function that returns whether the clock
     * should tick
     * @return boolean
     */
    public boolean getShouldTick() {
        return this.shouldTick;
    }
    /**
     * function that returns current state
     * @return state
     */
    public States getState() {
        return this.state;
    }

    /**
     * A method for adding a second to the clock
     */
    public void addSecond() {
        second.increase();
        if (second.get() == 0) {
            min.increase();
            if (min.get() == 0) {
                hour.increase();
            }
        }
    }

    /**
     * Method for adding an hour to the clock
     */
    public void addHour() {
        hour.increase();
    }
    
    /**
     * Method for subtracting an hour from the clock
     */
    public void subtractHour() {
        hour.decrease();
    }  
    
    /**
     * Method for adding a minute to the clock
     */
    public void addMinute() {
        min.increase();
    }
    
    /**
     * Method for subtracting a minute from the clock
     */
    public void subtractMinute() {
        min.decrease();
    } 
    
    /**
     * A method that ticks the clock every second
     */
    public void tick() {
        int delay = 1000;
        /* 1 second */
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (shouldTick) addSecond();
            }
        };
        Timer t = new Timer(delay, listener);
        t.start();

    }
    
    /**
     * Return the clock's data in string form
     * @return a string of the data
     */
    public String toString() {
        String theString = hour.toString();
        if (min.get() < 10) {
            theString+= ":0" + min.toString();
        }
        else theString+= ":" + min.toString();
        if (second.get() < 10) {
            theString+= ":0" + second.toString();
        }
        else theString+= ":" + second.toString();
        
        return theString;
    }
    
    /**
     * Method that lets you choose which part of the clock will be modified
     * @param state new state of state
     */
    public void setState(States state) {
        if (!shouldTick) this.state = state;
    }
    
    /**
     * Method that allows you to let the clock tick
     */
    public void setToTick() {
        setState(States.NOTHING);
        shouldTick = true;
    }
    
    /**
     * Method that allows you to set the clock to not tick
     */
    public void setNoTick() {
        shouldTick = false;
    }
    
    private Hour hour;
    private Minute min;
    private Second second;
    private boolean shouldTick;
    private States state;
    enum States {NOTHING, MINUTES, HOURS};
    
}
