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
 * @author Richard
 */
public class ImpalaJonesTest {

    /**
     * Test of getPosition method, of class ImpalaJones.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        ImpalaJones instance = new ImpalaJones();
        int expResult = 0;
        int result = instance.getPosition();
        assertEquals(expResult, result);
    
    }

    /**
     * Test of init method, of class ImpalaJones.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        int nb = 0;
        ImpalaJones instance = new ImpalaJones();
        instance.init(nb);
       
    }

    /**
     * Test of move method, of class ImpalaJones.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        int distance = 0;
        ImpalaJones instance = new ImpalaJones();
        instance.move(distance);
        
    }

    /**
     * Test of isUp method, of class ImpalaJones.
     */
    @Test
    public void testIsUp() {
        System.out.println("isUp");
        ImpalaJones instance = new ImpalaJones();
        boolean expResult = false;
        boolean result = instance.isUp();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of isDown method, of class ImpalaJones.
     */
    @Test
    public void testIsDown() {
        System.out.println("isDown");
        ImpalaJones instance = new ImpalaJones();
        boolean expResult = false;
        boolean result = instance.isDown();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isRight method, of class ImpalaJones.
     */
    @Test
    public void testIsRight() {
        System.out.println("isRight");
        ImpalaJones instance = new ImpalaJones();
        boolean expResult = false;
        boolean result = instance.isRight();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isLeft method, of class ImpalaJones.
     */
    @Test
    public void testIsLeft() {
        System.out.println("isLeft");
        ImpalaJones instance = new ImpalaJones();
        boolean expResult = false;
        boolean result = instance.isLeft();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getColumn method, of class ImpalaJones.
     */
    @Test
    public void testGetColumn() {
        System.out.println("getColumn");
        ImpalaJones instance = new ImpalaJones();
        int expResult = 0;
        int result = instance.getColumn();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getRow method, of class ImpalaJones.
     */
    @Test
    public void testGetRow() {
        System.out.println("getRow");
        ImpalaJones instance = new ImpalaJones();
        int expResult = 0;
        int result = instance.getRow();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of checkMove method, of class ImpalaJones.
     */
    @Test
    public void testCheckMove() {
        System.out.println("checkMove");
        Reserve reserve = null;
        int distance = 0;
        ImpalaJones instance = new ImpalaJones();
        boolean expResult = false;
        boolean result = instance.checkMove(reserve, distance);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of valid method, of class ImpalaJones.
     */
    @Test
    public void testValid() {
        System.out.println("valid");
        Coordinates pos = null;
        ImpalaJones instance = new ImpalaJones();
        boolean expResult = false;
        boolean result = instance.valid(pos);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of findFirst method, of class ImpalaJones.
     */
    @Test
    public void testFindFirst() {
        System.out.println("findFirst");
        Reserve reserve = null;
        ImpalaJones instance = new ImpalaJones();
        int expResult = 0;
        int result = instance.findFirst(reserve);
        assertEquals(expResult, result);
       
    }
    
}
