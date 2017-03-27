/*
 * Main method of the game project
 * @author dedec
 */
package g43142.zebras;

import g43142.zebras.models.Animal;
import g43142.zebras.models.Color;
import g43142.zebras.models.Coordinates;
import g43142.zebras.models.ImpalaJones;
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
        Animal unAnimal = new Animal(Species.G, Color.GREEN);
        Coordinates uneCoordonnée = new Coordinates(1, 3);  
        reserve.put( unAnimal, uneCoordonnée);
             
        System.out.println("--------------");
        System.out.println(reserve.getAnimal(uneCoordonnée)+uneCoordonnée.toString());
        System.out.println("--------------");
        
        //simple utilisation de l'enum Species
        System.out.println("animal : " + Species.G);
                
        System.out.println("*-------------------*");
        System.out.println("   RESERVE");
        System.out.println(reserve);
        System.out.println("*-------------------*");
        
        
        //création du stock des pièces
        Pieces p = new Pieces();
        Animal exempleAni = p.getAnimal(Color.GREEN, Species.G);
        Coordinates exempleCoord = new Coordinates(3, 5);
        reserve.put(exempleAni, exempleCoord);
        
        Animal autreAni = p.getAnimal(Color.RED, Species.L);
        Coordinates autreCoord = new Coordinates(0,1);
        reserve.put(autreAni, autreCoord);
        System.out.println("*-------------------*");
        System.out.println("   RESERVE 2");
        System.out.println(reserve);
        System.out.println("*-------------------*");
        
        
        System.out.println("affiche la liste d'animaux disp = "+p.toString());
        System.out.println("get animal: "+p.getAnimal(Color.GREEN, Species.G));
        System.out.println("liste modifié= "+p.toString());
        System.out.println("vide? "+p.hasAvailable());
        System.out.println("cmb de gazelle? "+p.getNbAnimal(Color.GREEN, Species.G));
        
        
        System.out.println("----------");
        reserve.put(autreAni, (new Coordinates(0, 0)));
        reserve.put(autreAni, (new Coordinates(0, 1)));
        reserve.put(autreAni, (new Coordinates(0, 2)));
        reserve.put(autreAni, (new Coordinates(0, 3)));
        reserve.put(autreAni, (new Coordinates(0, 4)));
        reserve.put(autreAni, (new Coordinates(0, 5)));
        
        System.out.println(reserve);
        System.out.println("test methode res.freerow(0.0)");
        System.out.println(reserve.freeRow(new Coordinates(0, 0)));
        
        ImpalaJones I = new ImpalaJones();
        System.out.println(I.findFirst(reserve));
        
    }
}
