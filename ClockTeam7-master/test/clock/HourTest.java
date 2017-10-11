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
public class HourTest {
    
    public HourTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("SetUp");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("TearDown");
    }

    /**
     * Test of increase method, of class Hour.
     */
    @Test
    public void testIncrease() {
        System.out.println("increase");
        Hour instance = new Hour(15);
        instance.increase();
        assertEquals(16, instance.get(), 0);
        Hour instance2 = new Hour(23);
        instance2.increase();
        assertEquals(0, instance2.get(), 0);
    }

    /**
     * Test of decrease method, of class Hour.
     */
    @Test
    public void testDecrease() {
        System.out.println("decrease");
        Hour instance = new Hour(15);
        instance.decrease();
        assertEquals(14, instance.get(), 0);
        Hour instance2 = new Hour(0);
        instance2.decrease();
        assertEquals(23, instance2.get(), 0);
    }

    /**
     * Test of get method, of class Hour.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        Hour instance = new Hour(10);
        int expResult = 10;
        int result = instance.get();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of toString method, of class Hour.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Hour instance = new Hour(10);
        String result = instance.toString();
        assertEquals("10", result);
    }
    
}
