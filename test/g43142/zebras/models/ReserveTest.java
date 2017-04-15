/*
 * Test of methods from Reserve.java class
 * @author g43142
 */
package g43142.zebras.models;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReserveTest {
       
    /**
     * Test of isFree method, of class Reserve.
     * return true if the case [0, 0] has NOT an animal.
     */
    @Test
    public void testIsFree() {
        System.out.println("isFree Method Test");
        
        Coordinates pos = new Coordinates(0, 0);
        Reserve instance = new Reserve();
        boolean expResult = true;
        boolean result = instance.isFree(pos);
        
        assertEquals(expResult, result);

    }
    
    /**
     * Test 2 of isFree method, of class Reserve.
     * return true if case [4, 5] has NOT an animal.
     */
    @Test
    public void testIsFree2() {
        System.out.println("isFree Method Test 2");
        
        Coordinates pos = new Coordinates(4, 5);
        Reserve instance = new Reserve();
        boolean expResult = true;
        boolean result = instance.isFree(pos);
        
        assertEquals(expResult, result);

    }
    
    /**
     * Test 3 of isFree method, of class Reserve.
     * return an error if the case is outside the board game
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testIsFree3() {
        System.out.println("isFree Method Test 3");
        
        Coordinates pos = new Coordinates(8, 10);
        Reserve instance = new Reserve();
        Animal animal = new Animal(Species.GAZELLE, Color.GREEN);
        instance.put(animal, pos);
        
         
    }
    
    /**
     * Test 4 of isFree method, of class Reserve.
     * return false because case [0, 0] has an animal (green gazelle)
     */
    @Test
    public void testIsFree4() {
        System.out.println("isFree Method Test 4");
        
        Coordinates pos = new Coordinates(0, 0);
        Reserve instance = new Reserve();
        Animal animal = new Animal(Species.GAZELLE, Color.GREEN);
        instance.put(animal, pos);
        boolean expResult = false;
        boolean result = instance.isFree(pos);
        
        assertEquals(expResult, result);

    }
    
    /**
     * Test 5 of isFree method, of class Reserve.
     * return false because case [0, 0] has an animal (red lion)
     */
    @Test
    public void testIsFree5() {
        System.out.println("isFree Method Test 5");
        
        Coordinates pos = new Coordinates(0, 0);
        Reserve instance = new Reserve();
        Animal animal = new Animal(Species.LION, Color.RED);
        instance.put(animal, pos);
        boolean expResult = false;
        boolean result = instance.isFree(pos);
        
        assertEquals(expResult, result);

    }  

    /**
     * Test of put method, of class Reserve.
     * test pass if the animal has been put in the case
     */
    @Test
    public void testPut() {
        System.out.println("put Method Test");
        
        Coordinates pos = new Coordinates(0, 0);
        Reserve instance = new Reserve();
        Animal animal = new Animal(Species.GAZELLE, Color.GREEN);
        instance.put(animal, pos);
        Animal animalExpected = instance.getAnimal(pos);
        
        assertEquals(animalExpected, animal);  

    }
    
    /**
     * Test 2 of put method, of class Reserve.
     * return an error because the case is out of the board game
     */
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testPut2() {
        System.out.println("put Method Test 2");
        
        Coordinates pos = new Coordinates(10, 10);
        Reserve instance = new Reserve();
        Animal animal = new Animal(Species.GAZELLE, Color.GREEN);
        instance.put(animal, pos);
        Animal animalExpected = instance.getAnimal(pos);
        
        assertEquals(animalExpected, animal);  

    }
    
    /**
     * Test of getAnimal method, of class Reserve.
     * compare if the animal put in the case [0, 0] is the same as the animal
     * from the method getAnimal, which is gazelle green
     */
    @Test
    public void testGetAnimal() {
        System.out.println("getAnimal Method Test");
        
        Coordinates pos = new Coordinates(0, 0);
        Reserve instance = new Reserve();
        Animal animal = new Animal(Species.GAZELLE, Color.GREEN);
        instance.put(animal, pos);
        Animal result = instance.getAnimal(pos);
        
        assertEquals(animal, result);
    }
    
    /**
     * Test 2 of getAnimal method, of class Reserve.
     * return an error because coordinates are out of the reserve
     */
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testGetAnimal2() {
        System.out.println("getAnimal Method Test 2");
        
        Coordinates pos = new Coordinates(13, 23);
        Reserve instance = new Reserve();
        Animal animal = new Animal(Species.GAZELLE, Color.GREEN);
        instance.put(animal, pos);
        Animal result = instance.getAnimal(pos);
        
        assertEquals(animal, result);
    }
    
    /**
     * Test 3 of getAnimal method, of class Reserve.
     * must return null because the coordinate is empty
     */
    @Test 
    public void testGetAnimal3() {        
        Coordinates pos = new Coordinates(0, 0);
        Reserve instance = new Reserve();
        Animal animal = null;
        Animal result = instance.getAnimal(pos);
        
        assertEquals(animal, result);
    }

    /**
     * Test of isInside method, of class Reserve.
     * Coordinates 1:1 is inside the reserve : test must be true
     */
    @Test
    public void testIsInside() {
        Coordinates pos = new Coordinates(1, 1);
        Reserve instance = new Reserve();
        boolean expResult = true;
        boolean result = instance.isInside(pos);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isInside method, of class Reserve.
     * Coordinates 6:7 is outside of the reserve : test must be false
     */
    @Test
    public void testIsInside2() {
        Coordinates pos = new Coordinates(6, 7);
        Reserve instance = new Reserve();
        boolean expResult = false;
        boolean result = instance.isInside(pos);
        assertEquals(expResult, result);
    }

    /**
     * Test of freeColumn method, of class Reserve.
     * reserve is empty : column 0 has free space to put an animal
     * test must be true
     */
    @Test
    public void testFreeColumn() {
        int col = 0;
        Reserve instance = new Reserve();
        boolean expResult = true;
        boolean result = instance.freeColumn(col);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of freeColumn method, of class Reserve.
     * reserve is not empty, but has still free space to put animal
     * test must be true
     */
    @Test
    public void testFreeColumn2() {
        int col = 0;
        Reserve instance = new Reserve();
        boolean expResult = true;
        instance.put(new Animal(Species.GAZELLE, Color.GREEN), 
                new Coordinates(0, 0));
        boolean result = instance.freeColumn(col);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of freeColumn method, of class Reserve.
     * first column of the reserve is full : impossible to put an animal
     * tust must be false
     */
    @Test
    public void testFreeColumn3() {
        int col = 0;
        Reserve instance = new Reserve();
        boolean expResult = false;
        Animal animal = new Animal(Species.GAZELLE, Color.GREEN);
        instance.put(animal, new Coordinates(0, 0));
        instance.put(animal, new Coordinates(1, 0));
        instance.put(animal, new Coordinates(2, 0));
        instance.put(animal, new Coordinates(3, 0));
        instance.put(animal, new Coordinates(4, 0));
        boolean result = instance.freeColumn(col);
        assertEquals(expResult, result);
    }

    /**
     * Test of freeRow method, of class Reserve.
     * reserve is empty : row 0 has free space to put an animal
     * test must be true
     */
    @Test
    public void testFreeRow() {
        int row = 0;
        Reserve instance = new Reserve();
        boolean expResult = true;
        boolean result = instance.freeRow(row);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of freeRow method, of class Reserve.
     * row 0 has only one animal: there is free space to put an animal
     * test must be true
     */
    @Test
    public void testFreeRow2() {
        int row = 0;
        Reserve instance = new Reserve();
        instance.put(new Animal(Species.GAZELLE, Color.GREEN),
                new Coordinates(0, 0));
        boolean expResult = true;
        boolean result = instance.freeRow(row);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of freeRow method, of class Reserve.
     * row 0 is full : impossible to put an animal
     * test must be false
     */
    @Test
    public void testFreeRow3() {
        int row = 0;
        Reserve instance = new Reserve();
        Animal animal = new Animal(Species.GAZELLE, Color.GREEN);
        instance.put(animal, new Coordinates(0, 0));
        instance.put(animal, new Coordinates(0, 1));
        instance.put(animal, new Coordinates(0, 2));
        instance.put(animal, new Coordinates(0, 3));
        instance.put(animal, new Coordinates(0, 4));
        instance.put(animal, new Coordinates(0, 5));
        boolean expResult = false;
        boolean result = instance.freeRow(row);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getAdjacents method, of class Reserve.
     * the positions next to (0,0) are 
     * down : (1,0)
     * right : (0,1)
     */
    @Test
    public void testGetAdjacents() {
        Coordinates pos = new Coordinates(0, 0);
        Reserve instance = new Reserve();
        List<Coordinates> expResult = new ArrayList<>();
        expResult.add(new Coordinates(1, 0));
        expResult.add(new Coordinates(0, 1));  
        List<Coordinates> result = instance.getAdjacents(pos);
        assertEquals(expResult.toString(), result.toString());
    }
    
    /**
     * Test of getAdjacents method, of class Reserve.
     * the positions next to (2, 2) are
     * up : (1, 2)
     * down : (3, 2)
     * left : (2, 1)
     * right : (2, 3)
     */
    @Test
    public void testGetAdjacents2() {
        Coordinates pos = new Coordinates(2, 2);
        Reserve instance = new Reserve();
        List<Coordinates> expResult = new ArrayList<>();
        expResult.add(new Coordinates(1, 2));
        expResult.add(new Coordinates(3, 2));
        expResult.add(new Coordinates(2, 1));
        expResult.add(new Coordinates(2, 3));
        List<Coordinates> result = instance.getAdjacents(pos);
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of isBorder method, of class Reserve.
     * coordinates 2:2 is not on the border of the reserve
     */
    @Test
    public void testIsBorder() {
        Coordinates pos = new Coordinates(2, 2);
        Reserve instance = new Reserve();
        boolean expResult = false;
        boolean result = instance.isBorder(pos);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isBorder method, of class Reserve.
     * coordiantes 0:0 is on the the border of the reserve
     */
    @Test
    public void testIsBorder2() {
        Coordinates pos = new Coordinates(0, 0);
        Reserve instance = new Reserve();
        boolean expResult = true;
        boolean result = instance.isBorder(pos);
        assertEquals(expResult, result);
    }

    /**
     * Test of isUP method, of class Reserve.
     * Coordinates 0:0 is on the up side of the reserve
     * test must be true
     */
    @Test
    public void testIsUP() {
        Coordinates pos = new Coordinates(0, 0);
        Reserve instance = new Reserve();
        boolean expResult = true;
        boolean result = instance.isUP(pos);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isUP method, of class Reserve.
     * Coordinates :0 is not on the up side of the reserve
     * test must be false
     */
    @Test
    public void testIsUP2() {
        Coordinates pos = new Coordinates(1, 0);
        Reserve instance = new Reserve();
        boolean expResult = false;
        boolean result = instance.isUP(pos);
        assertEquals(expResult, result);
    }

    /**
     * Test of isDown method, of class Reserve.
     * Coordinates 0:0 is not on the down side of the reserve
     * test must be false
     */
    @Test
    public void testIsDown() {
        Coordinates pos = new Coordinates(0, 0);
        Reserve instance = new Reserve();
        boolean expResult = false;
        boolean result = instance.isDown(pos);
        assertEquals(expResult, result);
    }
    /**
     * Test of isDown method, of class Reserve.
     * Coordinates 4:0 is on the down side of the reserve
     * test must be true
     */
    @Test
    public void testIsDown2() {
        Coordinates pos = new Coordinates(4, 0);
        Reserve instance = new Reserve();
        boolean expResult = true;
        boolean result = instance.isDown(pos);
        assertEquals(expResult, result);
    }

    /**
     * Test of isRight method, of class Reserve.
     * Coordinates 0:5 is on the right side of the reserve
     * test must be true
     */
    @Test
    public void testIsRight() {
        Coordinates pos = new Coordinates(0, 5);
        Reserve instance = new Reserve();
        boolean expResult = true;
        boolean result = instance.isRight(pos);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isRight method, of class Reserve.
     * Coordinates 0:0 is not on the right side of the reserve
     * test must be false
     */
    @Test
    public void testIsRight2() {
        Coordinates pos = new Coordinates(0, 0);
        Reserve instance = new Reserve();
        boolean expResult = false;
        boolean result = instance.isRight(pos);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isLeft method, of class Reserve.
     * Coordinates 0:1 is not on the left side of the reserve
     * test must be false
     */
    @Test
    public void testIsLeft() {
        Coordinates pos = new Coordinates(0, 1);
        Reserve instance = new Reserve();
        boolean expResult = false;
        boolean result = instance.isLeft(pos);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isLeft method, of class Reserve.
     * Coordinates 0:0 is on the left side of the reserve
     * test must be true
     */
    @Test
    public void testIsLeft2() {
        Coordinates pos = new Coordinates(0, 0);
        Reserve instance = new Reserve();
        boolean expResult = true;
        boolean result = instance.isLeft(pos);
        assertEquals(expResult, result);
    }
   
}
