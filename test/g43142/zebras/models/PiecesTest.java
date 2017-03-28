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
 * @author dedec
 */
public class PiecesTest {
    
    public PiecesTest() {
    }

    /**
     * Test of hashCode method, of class Pieces.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Pieces instance = new Pieces();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Pieces.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Pieces instance = new Pieces();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnimal method, of class Pieces.
     */
    @Test
    public void testGetAnimal() {
        System.out.println("getAnimal");
        Color color = null;
        Species species = null;
        Pieces instance = new Pieces();
        Animal expResult = null;
        Animal result = instance.getAnimal(color, species);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasAvailable method, of class Pieces.
     */
    @Test
    public void testHasAvailable() {
        System.out.println("hasAvailable");
        Pieces instance = new Pieces();
        
        boolean expResult = false;
        boolean result = instance.hasAvailable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNbAnimal method, of class Pieces.
     */
    @Test
    public void testGetNbAnimal() {
        System.out.println("getNbAnimal");
        Color color = null;
        Species species = null;
        Pieces instance = new Pieces();
        long expResult = 0L;
        long result = instance.getNbAnimal(color, species);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Pieces.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Pieces instance = new Pieces();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
