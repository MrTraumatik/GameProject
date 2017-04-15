package g43142.zebras.models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *Test class for the methods of ImpalaJones.java class
 * @author Richard
 */
public class ImpalaJonesTest {

    /**
     * Test of getPosition method, of class ImpalaJones.
     * Instantiation of object ImpalaJones positions him at -1
     * so getPosition should give "-1"
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
     * init(pos) put Impala at the position pos
     * so getPosition should give 0
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
     * move(pos) make Impala go to the position pos
     * so getPositon should give the pos (+1 since Impala start at -1)
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
     * init put Impala at the position pos of init(pos)
     * so if nb =0, init(nb) should put Impala at 0
     */
    @Test
    public void testInit() {
        int nb = 0;
        ImpalaJones instance = new ImpalaJones();
        instance.init(nb);
       
    }

    /**
     * Test of move method, of class ImpalaJones.
     * move take Impala's position and add it the pos in parameter
     * so move(distance), where distance = 0, should make Impala stay where he is 
     */
    @Test
    public void testMove() {
        int distance = 0;
        ImpalaJones instance = new ImpalaJones();
        instance.move(distance);
        
    }
    
    /**
     * Test of move method, of class ImpalaJones.
     * move take Impala's position and add it the pos in parameter
     * so move(9) should make Impala go 9 positions further
     */
    @Test
    public void testMove2() {
        int distance = 9;
        ImpalaJones instance = new ImpalaJones();
        instance.move(distance);
        
    }
    
    /**
     * Test of move method, of class ImpalaJones.
     * move take Impala's position and add it the pos in parameter
     * so move(30) should give an exception because 30 is above 21 (position max)
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
     * Impala's position is 0 so he's on the top of the boardgame
     * so isUp should return true
     */
    @Test
    public void testIsUp() {
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        boolean expResult = true;
        boolean result = instance.isUp();
        assertEquals(expResult, result);
       
    }
    
    /**
     * Test of isUp method, of class ImpalaJones.
     * Impala's position is 10 so he's on the right side of the reserve
     * so isUp should return false
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
     * Impala's position is 0 so he's on the top of the reserve
     * so isDown should return false
     */
    @Test
    public void testIsDown() {
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        boolean expResult = false;
        boolean result = instance.isDown();
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of isDown method, of class ImpalaJones.
     * Impala's position is 15 so he's on the down side of the reserve
     * so isDown should return true
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
     * Impala's position is 0 so he's on the top side
     * so isRight should return false
     */
    @Test
    public void testIsRight() {
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        boolean expResult = false;
        boolean result = instance.isRight();
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of isRight method, of class ImpalaJones.
     * Impala's position is 9, so he's on the right side
     * so isRigth should return true
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
     * Impala's position is 0, so he's on the top side
     * so isLeft should return false
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
     * Impala's position is 17, so he's on the left side
     * so isLeft should return true
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
     * Impala's position : 0 , so getColumn should return 0
     */
    @Test
    public void testGetColumn() {
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        int expResult = 0;
        int result = instance.getColumn();
        assertEquals(expResult, result);
       
    }
    
    /**
     * Test of getColumn method, of class ImpalaJones.
     * Impala's position : 2, so getColumn should return 2
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
     * Impala's position : 6 , so getRow should return 0
     */
    @Test
    public void testGetRow() {
        ImpalaJones instance = new ImpalaJones();
        instance.move(7);
        int expResult = 0;
        int result = instance.getRow();
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of getRow method, of class ImpalaJones.
     * Impala's position : 11, so getRow should return 4
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
     * Impala's position is 0 and pos is[0, 0]
     * so valid(pos) should return true
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
     * Impala's position is 2 and pos is[0, 0]
     * so valid(pos) should return false
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
     * reserve is empty by default : the first move
     * avalaible is 1 
     * 
     * @throws Exception throw a Game exception if the 
     * reserve is full
     */
    @Test
    public void testFindFirst() throws Exception {
        Reserve reserve = new Reserve();
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        int expResult = 1;
        int result = instance.findFirst(reserve);
        assertEquals(expResult, result);
    }
    
    /**
     * Test 2 of findFirst method, of class ImpalaJones.
     * the column 1 is full : the first move avalaible is 2
     * 
     * @throws Exception throw a Game exception if the
     * reserve is full
     */
    @Test
    public void testFindFirst2() throws Exception {
        Reserve reserve = new Reserve();
        ImpalaJones instance = new ImpalaJones();
        instance.init(0);
        Animal animal = new Animal(Species.GAZELLE, Color.GREEN);
        reserve.put(animal, new Coordinates(0, 1));
        reserve.put(animal, new Coordinates(1, 1));
        reserve.put(animal, new Coordinates(2, 1));
        reserve.put(animal, new Coordinates(3, 1));
        reserve.put(animal, new Coordinates(4, 1));
        
        int expResult = 2;
        int result = instance.findFirst(reserve);
        assertEquals(expResult, result);
    }
    
    
}
