/*
 * Le pointeur d'entrée du jeu.
 * @author dedec
 */
package g43142.zebras;

import g43142.zebras.models.Animal;
import g43142.zebras.models.Color;
import g43142.zebras.models.Coordinates;
import g43142.zebras.models.Reserve;
import g43142.zebras.models.Species;
import java.util.Arrays;

public class Zebras {
    public static void main(String[] args) {
        
        //instancie une reserve        
        Reserve reserve = new Reserve();
        
        //place une gazelle : (2, 4)
        //possible de le faire sans la couleur ??
        Animal unAnimal = new Animal(Species.GAZELLE, Color.GREEN);
        Coordinates uneCoordonnée = new Coordinates(1, 3);  
        reserve.put( unAnimal, uneCoordonnée);
        
        
        //affiche le résultat en console
        String posi = reserve.getCoordinates(uneCoordonnée);
        System.out.println(reserve.getAnimal(uneCoordonnée)+ posi);
        
        //simple utilisation de l'enum Species
        System.out.println("animal :" + Species.GAZELLE);
        
        //affiche false, donc case est remplis
        System.out.print("la case 2x4 est elle vide ?");
        System.out.println(reserve.isFree(uneCoordonnée));
        //affiche true, méthode est donc correcte !
        System.out.print("la case 0x0 est elle vide ?");
        System.out.println(reserve.isFree(new Coordinates(0, 0)));
        
        
        
        System.out.println(reserve);
    }
}
