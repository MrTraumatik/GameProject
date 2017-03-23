/*
 * Test of methods from Reserve.java class
 * @author g43142
 */
package g43142.zebras.models;

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
   
}
