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
public class PiecesTest {
    
    /**
     * Test of getAnimal method, of class Pieces.
     */
    @Test
    public void testGetAnimal() {
        
        Animal animal = new Animal(Species.GAZELLE, Color.GREEN);
        Pieces instance = new Pieces();
        Animal expResult = animal;
        Animal result = instance.getAnimal(Color.GREEN, Species.GAZELLE);
        assertEquals(expResult.toString(), result.toString());

    }

    /**
     * Test of hasAvailable method, of class Pieces.
     */
    @Test
    public void testHasAvailable() {
        Pieces instance = new Pieces();
        boolean expResult = false;
        boolean result = instance.hasAvailable();
        assertEquals(expResult, result);
   
    }
    
    /**
     * Test 2 of hasAvailable method, of class Pieces.
     */
    @Test
    public void testHasAvailable2() {
        Pieces instance = new Pieces();
        for(int i=0;i<6;i++){
            instance.getAnimal(Color.RED, Species.GAZELLE);
            instance.getAnimal(Color.GREEN, Species.GAZELLE);
        }
        for(int i=0;i<5;i++){
            instance.getAnimal(Color.RED, Species.ZEBRA);
            instance.getAnimal(Color.GREEN, Species.ZEBRA);
        }
        for(int i=0;i<2;i++){
            instance.getAnimal(Color.RED, Species.CROCODILE);
            instance.getAnimal(Color.GREEN, Species.CROCODILE);
        }
        instance.getAnimal(Color.RED, Species.LION);
        instance.getAnimal(Color.RED, Species.ELEPHANT);
        instance.getAnimal(Color.GREEN, Species.LION);
        instance.getAnimal(Color.GREEN, Species.ELEPHANT);
        boolean expResult = true;
        boolean result = instance.hasAvailable();
        assertEquals(expResult, result);
   
    }
    

    /**
     * Test of getNbAnimal method, of class Pieces.
     */
    @Test
    public void testGetNbAnimal() {
        Pieces instance = new Pieces();
        int expResult = 6;
        int result = instance.getNbAnimal(Color.GREEN, Species.GAZELLE);
        assertEquals(expResult, result); 
    }
    
    /**
     * Test 2 of getNbAnimal method, of class Pieces.
     */
    @Test
    public void testGetNbAnimal2() {
        Pieces instance = new Pieces();
        int expResult = 5;
        int result = instance.getNbAnimal(Color.GREEN, Species.ZEBRA);
        assertEquals(expResult, result); 
    }
    
    /**
     * Test 3 of getNbAnimal method, of class Pieces.
     */
    @Test
    public void testGetNbAnimal3() {
        Pieces instance = new Pieces();
        int expResult = 0;
        instance.getAnimal(Color.GREEN, Species.LION);
        int result = instance.getNbAnimal(Color.GREEN, Species.LION);
        assertEquals(expResult, result); 
    }
    
    /**
     * Test of getNbAnimal method, of class Pieces.
     */
    @Test
    public void testGetNbAnimal4() {
        Pieces instance = new Pieces();
        int expResult = 0;
        instance.getAnimal(Color.RED, Species.GAZELLE);
        instance.getAnimal(Color.RED, Species.GAZELLE);
        instance.getAnimal(Color.RED, Species.GAZELLE);
        instance.getAnimal(Color.RED, Species.GAZELLE);
        instance.getAnimal(Color.RED, Species.GAZELLE);
        instance.getAnimal(Color.RED, Species.GAZELLE);
        int result = instance.getNbAnimal(Color.RED, Species.GAZELLE);
        assertEquals(expResult, result); 
    }

    /**
     * Test of toString method, of class Pieces.
     */
    @Test
    public void testToString() {
        Pieces instance = new Pieces();
        String expResult = "\n  STOCK\n----------\n" + 6 + " Gazelle(s)\n"
                + 5 + " Zèbre(s)\n" + 2 + " Corcodile(s)\n" 
                + 1 + " Lion\n" + 1 + " Eléphant";
        
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of put method, of class Pieces.
     */
    @Test
    public void testPut() {
        Animal animal = new Animal(Species.GAZELLE, Color.GREEN);
        Pieces instance = new Pieces();
        instance.put(animal);
        
    }
    
}
