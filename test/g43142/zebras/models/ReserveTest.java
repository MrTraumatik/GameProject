/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g43142.zebras.models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author g43142
 */
public class ReserveTest {
    
    public ReserveTest() {
    }
    
    /**
     * Test of isFree method, of class Reserve.
     */
    @Test
    public void testIsFree() {
        System.out.println("isFree");
        Coordinates pos = null;
        Reserve instance = new Reserve();
        boolean expResult = false;
        boolean result = instance.isFree(pos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of put method, of class Reserve.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        Animal animal = null;
        Coordinates pos = null;
        Reserve instance = new Reserve();
        instance.put(animal, pos);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAnimal method, of class Reserve.
     */
    @Test
    public void testGetAnimal() {
        System.out.println("getAnimal");
        Coordinates pos = null;
        Reserve instance = new Reserve();
        Animal expResult = null;
        Animal result = instance.getAnimal(pos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCoordinates method, of class Reserve.
     */
    @Test
    public void testGetCoordinates() {
        System.out.println("getCoordinates");
        Coordinates pos = null;
        Reserve instance = new Reserve();
        String expResult = "";
        String result = instance.getCoordinates(pos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Reserve.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Reserve instance = new Reserve();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
