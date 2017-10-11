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
public class MinuteTest {
    
    public MinuteTest() {
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
     * Test of increase method, of class Minute.
     */
    @Test
    public void testIncrease() {
        System.out.println("increase");
        Minute instance = new Minute(30);
        instance.increase();
        assertEquals(31, instance.get(), 0);
        Minute instance2 = new Minute(59);
        instance2.increase();
        assertEquals(0, instance2.get(), 0);
    }

    /**
     * Test of decrease method, of class Minute.
     */
    @Test
    public void testDecrease() {
        System.out.println("decrease");
        Minute instance = new Minute(30);
        instance.decrease();
        assertEquals(29, instance.get(), 0);
        Minute instance2 = new Minute(0);
        instance2.decrease();
        assertEquals(59, instance2.get(), 0);
    }

    /**
     * Test of get method, of class Minute.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        Minute instance = new Minute(30);
        int expResult = 30;
        int result = instance.get();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of toString method, of class Minute.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Minute instance = new Minute(10);
        String result = instance.toString();
        assertEquals("10", result);
    }
    
}
