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
        ImpalaJones instance = new ImpalaJones();
        int expResult = -1;
        int result = instance.getPosition();
        assertEquals(expResult, result);
    
    }
    
    /**
     * Test2 of getPosition method, of class ImpalaJones.
     */
    @Test
    public void testGetPosition2() {
        ImpalaJones instance = new ImpalaJones();
        int expResult = 0;
        instance.init(0);
        int result = instance.getPosition();
        assertEquals(expResult, result);
    
    }
    
    /**
     * Test3 of getPosition method, of class ImpalaJones.
     */
    @Test
    public void testGetPosition3() {
        ImpalaJones instance = new ImpalaJones();
        int expResult = 20;
        instance.move(21);
        int result = instance.getPosition();
        assertEquals(expResult, result);
    
    }

    /**
     * Test of init method, of class ImpalaJones.
     */
    @Test
    public void testInit() {
        int nb = 0;
        ImpalaJones instance = new ImpalaJones();
        instance.init(nb);
       
    }

    /**
     * Test of move method, of class ImpalaJones.
     */
    @Test
    public void testMove() {
        int distance = 0;
        ImpalaJones instance = new ImpalaJones();
        instance.move(distance);
        
    }
    
    /**
     * Test of move method, of class ImpalaJones.
     */
    @Test
    public void testMove2() {
        int distance = 9;
        ImpalaJones instance = new ImpalaJones();
        instance.move(distance);
        
    }
    
    /**
     * Test of move method, of class ImpalaJones.
     */
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testMove3() {
        int distance = 30;
        ImpalaJones instance = new ImpalaJones();
        instance.move(distance);
        assertEquals(distance, distance);
        
    }

    /**
     * Test of isUp method, of class ImpalaJones.
     */
    @Test
    public void testIsUp() {
        ImpalaJones instance = new ImpalaJones();
        boolean expResult = true;
        boolean result = instance.isUp();
        assertEquals(expResult, result);
       
    }
    
    /**
     * Test of isUp method, of class ImpalaJones.
     */
    @Test
    public void testIsUp2() {
        ImpalaJones instance = new ImpalaJones();
        instance.move(10);
        boolean expResult = false;
        boolean result = instance.isUp();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of isDown method, of class ImpalaJones.
     */
    @Test
    public void testIsDown() {
        ImpalaJones instance = new ImpalaJones();
        boolean expResult = false;
        boolean result = instance.isDown();
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of isDown method, of class ImpalaJones.
     */
    @Test
    public void testIsDown2() {
        ImpalaJones instance = new ImpalaJones();
        instance.move(15);
        boolean expResult = true;
        boolean result = instance.isDown();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isRight method, of class ImpalaJones.
     */
    @Test
    public void testIsRight() {
        ImpalaJones instance = new ImpalaJones();
        boolean expResult = false;
        boolean result = instance.isRight();
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of isRight method, of class ImpalaJones.
     */
    @Test
    public void testIsRight2() {
        ImpalaJones instance = new ImpalaJones();
        instance.move(9);
        boolean expResult = true;
        boolean result = instance.isRight();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isLeft method, of class ImpalaJones.
     */
    @Test
    public void testIsLeft() {
        ImpalaJones instance = new ImpalaJones();
        boolean expResult = false;
        boolean result = instance.isLeft();
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of isLeft method, of class ImpalaJones.
     */
    @Test
    public void testIsLeft2() {
        ImpalaJones instance = new ImpalaJones();
        instance.move(17);
        boolean expResult = true;
        boolean result = instance.isLeft();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getColumn method, of class ImpalaJones.
     */
    @Test
    public void testGetColumn() {
        ImpalaJones instance = new ImpalaJones();
        int expResult = 0;
        int result = instance.getColumn();
        assertEquals(expResult, result);
       
    }
    
    /**
     * Test of getColumn method, of class ImpalaJones.
     */
    @Test
    public void testGetColumn2() {
        ImpalaJones instance = new ImpalaJones();
        instance.move(3);
        int expResult = 2;
        int result = instance.getColumn();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getRow method, of class ImpalaJones.
     */
    @Test
    public void testGetRow() {
        ImpalaJones instance = new ImpalaJones();
        int expResult = 0;
        int result = instance.getRow();
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of getRow method, of class ImpalaJones.
     */
    @Test
    public void testGetRow2() {
        ImpalaJones instance = new ImpalaJones();
        instance.move(11);
        int expResult = 4;
        int result = instance.getRow();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of checkMove method, of class ImpalaJones.
     */
    @Test
    public void testCheckMove() {
        Reserve reserve = new Reserve();
        int distance = 1;
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        boolean expResult = true;
        boolean result = instance.checkMove(reserve, distance);
        assertEquals(expResult, result);
       
    }
    
    /**
     * Test of checkMove method, of class ImpalaJones.
     */
    @Test
    public void testCheckMove2() {
        Reserve reserve = new Reserve();
        int distance = 1;
        Animal animal = new Animal(Species.GAZELLE, Color.GREEN);
        Coordinates pos = new Coordinates(0, 1);
        Coordinates pos1 = new Coordinates(1, 1);
        Coordinates pos2 = new Coordinates(2, 1);
        Coordinates pos3 = new Coordinates(3, 1);
        Coordinates pos4 = new Coordinates(4, 1);
        reserve.put(animal, pos);
        reserve.put(animal, pos1);
        reserve.put(animal, pos2);
        reserve.put(animal, pos3);
        reserve.put(animal, pos4);
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        boolean expResult = false;
        boolean result = instance.checkMove(reserve, distance);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of valid method, of class ImpalaJones.
     */
    @Test
    public void testValid() {
        Coordinates pos = new Coordinates(0, 0);
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        boolean expResult = true;
        boolean result = instance.valid(pos);
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of valid method, of class ImpalaJones.
     */
    @Test
    public void testValid2() {
        Coordinates pos = new Coordinates(0, 0);
        ImpalaJones instance = new ImpalaJones();
        instance.move(3);
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
