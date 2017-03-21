/*
 * Test des méthodes de la classe Reserve.java
 * @author g43142
 */
package g43142.zebras.models;

import org.junit.Test;
import static org.junit.Assert.*;

public class ReserveTest {
       
    
    /**
     * Test of isFree method, of class Reserve.
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
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testIsFree3() {
        System.out.println("isFree Method Test 3");
        
        Coordinates pos = new Coordinates(8, 10);
        Reserve instance = new Reserve();
        Animal animal = new Animal(Species.GAZELLE, Color.GREEN);
        instance.put(animal, pos);
 
        //TESTER UNE ERREUR   
    }
    
    /**
     * Test 4 of isFree method, of class Reserve.
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
     * Test of getCoordinates method, of class Reserve.
     */
    @Test
    public void testGetCoordinates() {
        System.out.println("getCoordinates Method Test");
        
        Coordinates pos = new Coordinates(0, 0);
        Reserve instance = new Reserve();
        String expResult = "[1][1]";
        String result = instance.getCoordinates(pos);
        
        assertEquals(expResult, result);

    }
    
}
