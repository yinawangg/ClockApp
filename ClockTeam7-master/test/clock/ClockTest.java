/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author trparsonsgrayson
 */
public class ClockTest {
    
    public ClockTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("setUp");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("tearDown");
    }

    /**
     * Test of getHour method, of class Clock.
     */
    @Test
    public void testGetHour() {
        System.out.println("getHour");
        Clock instance = new Clock(1,1,1);
        int expResult = 1;
        int result = instance.getHour();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMinute method, of class Clock.
     */
    @Test
    public void testGetMinute() {
        System.out.println("getMinute");
        Clock instance = new Clock(1,1,1);
        int expResult = 1;
        int result = instance.getMinute();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSeconds method, of class Clock.
     */
    @Test
    public void testGetSeconds() {
        System.out.println("getSeconds");
        Clock instance = new Clock(1,1,1);;
        int expResult = 1;
        int result = instance.getSeconds();
        assertEquals(expResult, result);
    }

    /**
     * Test of addHour method, of class Clock.
     */
    @Test
    public void testAddHour() {
        System.out.println("addHour");
        Clock instance = new Clock(1,1,1);;
        instance.addHour();
        int result = instance.getHour();
        assertEquals(result, 2);
    }

    /**
     * Test of subtractHour method, of class Clock.
     */
    @Test
    public void testSubtractHour() {
        System.out.println("subtractHour");
        Clock instance = new Clock(1,1,1);;
        instance.subtractHour();
        int result = instance.getHour();
        assertEquals(result, 0);
    }

    /**
     * Test of addMinute method, of class Clock.
     */
    @Test
    public void testAddMinute() {
        System.out.println("addMinute");
        Clock instance = new Clock(1,1,1);
        instance.addMinute();
        int result = instance.getMinute();
        assertEquals(result, 2);
    }

    /**
     * Test of subtractMinute method, of class Clock.
     */
    @Test
    public void testSubtractMinute() {
        System.out.println("subtractMinute");
        Clock instance = new Clock(1,1,1);
        instance.subtractMinute();
        int result = instance.getMinute();
        assertEquals(result, 0);
    }

    /**
     * Test of tick method, of class Clock.
     */
    @Test
    public void testTick() {
        System.out.println("Not testable");
       
    }

    /**
     * Test of toString method, of class Clock.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Clock instance = new Clock(1,1,1);
        String expResult = "1:01:01";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of setState method, of class Clock.
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        Clock.States state = Clock.States.HOURS;
        Clock instance = new Clock(1,1,1);
        instance.setNoTick();
        instance.setState(state);
        assertEquals(instance.getState(), Clock.States.HOURS);
    }
    
    /**
     * Test of getState method, of class Clock.
     */
    @Test
    public void testGetState() {
        System.out.println("setState");
        Clock.States state = Clock.States.HOURS;
        Clock instance = new Clock(1,1,1);
        instance.setNoTick();
        instance.setState(state);
        assertEquals(instance.getState(), Clock.States.HOURS);
    }

    /**
     * Test of setToTick method, of class Clock.
     */
    @Test
    public void testSetToTick() {
        System.out.println("setToTick");
        Clock instance = new Clock(1,1,1);
        instance.setToTick();
        System.out.println("Can't get so not testable");
    }
    
    /**
     * Test of setNoTick method, of class Clock.
     */
    @Test
    public void testSetNoTick() {
        System.out.println("setNoTick");
        Clock instance = new Clock(1,1,1);
        instance.setNoTick();
        System.out.println("Can't get so not testable");
    }
    
}
