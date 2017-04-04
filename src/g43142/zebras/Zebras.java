/*
 * Main method of the game project
 * @author dedec
 */
package g43142.zebras;

import g43142.zebras.models.GameException;
import g43142.zebras.models.Animal;
import g43142.zebras.models.Color;
import g43142.zebras.models.Coordinates;
import g43142.zebras.models.Game;
import g43142.zebras.models.GameStatus;
import g43142.zebras.models.ImpalaJones;
import g43142.zebras.models.Pieces;
import g43142.zebras.models.Player;
import g43142.zebras.models.Reserve;
import g43142.zebras.models.Species;
import java.util.ArrayList;
import java.util.List;

public class Zebras {

    public static void main(String[] args) throws GameException {

        Reserve reserve = new Reserve();
        ImpalaJones impala = new ImpalaJones();
        Pieces pieces = new Pieces();
        List<Player> players = new ArrayList();
        Player currentPlayer = new Player(Color.GREEN);
        Game game = new Game(players, reserve, impala, pieces, GameStatus.INIT, currentPlayer);
        
        game.play(game);
    }

    public static void fill(Reserve res) {
        Animal animal = new Animal(Species.GAZELLE, Color.GREEN);
        res.put(animal, new Coordinates(0, 0));
        res.put(animal, new Coordinates(0, 1));
        res.put(animal, new Coordinates(0, 2));
        res.put(animal, new Coordinates(0, 3));
        res.put(animal, new Coordinates(0, 4));
        res.put(animal, new Coordinates(0, 5));
        res.put(animal, new Coordinates(1, 0));
        res.put(animal, new Coordinates(1, 1));
        res.put(animal, new Coordinates(1, 2));
        res.put(animal, new Coordinates(1, 3));
        res.put(animal, new Coordinates(1, 4));
        res.put(animal, new Coordinates(1, 5));
        res.put(animal, new Coordinates(2, 0));
        res.put(animal, new Coordinates(2, 1));
        res.put(animal, new Coordinates(2, 2));
        res.put(animal, new Coordinates(2, 3));
        res.put(animal, new Coordinates(2, 4));
        res.put(animal, new Coordinates(2, 5));
        res.put(animal, new Coordinates(3, 0));
        res.put(animal, new Coordinates(3, 1));
        res.put(animal, new Coordinates(3, 2));
        res.put(animal, new Coordinates(3, 3));
        res.put(animal, new Coordinates(3, 4));
        res.put(animal, new Coordinates(3, 5));
        res.put(animal, new Coordinates(4, 0));
        res.put(animal, new Coordinates(4, 1));
        res.put(animal, new Coordinates(4, 2));
        res.put(animal, new Coordinates(4, 3));
        res.put(animal, new Coordinates(4, 4));
        res.put(animal, new Coordinates(4, 5));

    }

    public static void oneRow(Reserve res) {
        Animal animal = new Animal(Species.GAZELLE, Color.RED);
        res.put(animal, new Coordinates(0, 0));
        res.put(animal, new Coordinates(0, 1));
        res.put(animal, new Coordinates(0, 2));
        res.put(animal, new Coordinates(0, 3));
        res.put(animal, new Coordinates(0, 4));
        res.put(animal, new Coordinates(0, 5));
    }

    public static void oneCol(Reserve res) {
        Animal animal = new Animal(Species.LION, Color.RED);
        res.put(animal, new Coordinates(0, 1));
        res.put(animal, new Coordinates(1, 1));
        res.put(animal, new Coordinates(2, 1));
        res.put(animal, new Coordinates(3, 1));
        res.put(animal, new Coordinates(4, 1));
    }
    
    
    public static void rien(){
        //instancie une reserve + place gazelle [2,4]     
        Reserve reserve = new Reserve();
        Animal unAnimal = new Animal(Species.GAZELLE, Color.GREEN);
        Coordinates uneCoordonnée = new Coordinates(1, 3);
        reserve.put(unAnimal, uneCoordonnée);

        //création du stock des pièces
        Pieces p = new Pieces();
        Animal exempleAni = p.getAnimal(Color.GREEN, Species.GAZELLE);
        Coordinates exempleCoord = new Coordinates(3, 5);
        reserve.put(exempleAni, exempleCoord);

        Animal autreAni = p.getAnimal(Color.RED, Species.LION);
        Coordinates autreCoord = new Coordinates(0, 1);
        reserve.put(autreAni, autreCoord);
        System.out.println("*-------------------*");
        System.out.println("   RESERVE ");
        System.out.println(reserve);
        System.out.println("*-------------------*");

        System.out.println("affiche la liste d'animaux disp = " + p.toString());
        System.out.println("");
        System.out.println("get animal: " + p.getAnimal(Color.GREEN, Species.GAZELLE));
        System.out.println("vide? " + p.hasAvailable());
        System.out.println("cmb de gazelle? " + p.getNbAnimal(Color.GREEN, Species.GAZELLE));

        System.out.println("--------------------");
        ImpalaJones I = new ImpalaJones();
        I.init(0);
        System.out.println(reserve);
        System.out.println("impala pos = " + I.getPosition());
        System.out.println("check move: " + I.checkMove(reserve, 2));
        //System.out.println("first move avalaible = " + I.findFirst(reserve));
        
        List<Player> players = new ArrayList();
        Player currentPlayer = new Player(Color.GREEN);
        
        Game game = new Game(players, reserve, I, p, GameStatus.INIT, currentPlayer);
       // game.play(game);
    }

}
