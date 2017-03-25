/*
 * Main method of the game project
 * @author dedec
 */
package g43142.zebras;

import g43142.zebras.models.Animal;
import g43142.zebras.models.Color;
import g43142.zebras.models.Coordinates;
import g43142.zebras.models.Pieces;
import g43142.zebras.models.Reserve;
import g43142.zebras.models.Species;
import java.util.List;

public class Zebras {
    public static void main(String[] args) {
        
        //instancie une reserve        
        Reserve reserve = new Reserve();
        
        //place une gazelle : (2, 4)
        //possible de le faire sans la couleur ??
        Animal unAnimal = new Animal(Species.GAZELLE, Color.GREEN);
        Coordinates uneCoordonnée = new Coordinates(1, 3);  
        reserve.put( unAnimal, uneCoordonnée);
             
        System.out.println("--------------");
        String posi = reserve.getCoordinates(uneCoordonnée);
        System.out.println(reserve.getAnimal(uneCoordonnée)+ posi);
        System.out.println("--------------");
        
        //simple utilisation de l'enum Species
        System.out.println("animal : " + Species.GAZELLE);
                
        System.out.println("*--------------------------*");
        System.out.println("           RESERVE");
        System.out.println(reserve);
        System.out.println("*--------------------------*");
        
        
        
        Pieces p = new Pieces();
        System.out.println(p.toString());
        
        System.out.println(p.getAnimal(Color.GREEN, Species.GAZELLE));
        
        System.out.println(p.toString());
        
        System.out.println(p.hasAvailable());
        
        System.out.println(p.getNbAnimal(Color.GREEN, Species.GAZELLE));
        

        
    }
}
