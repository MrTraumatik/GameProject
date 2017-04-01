package g43142.zebras;

import g43142.zebras.models.Animal;
import g43142.zebras.models.Color;
import g43142.zebras.models.Coordinates;
import g43142.zebras.models.GameStatus;
import g43142.zebras.models.ImpalaJones;
import g43142.zebras.models.Pieces;
import g43142.zebras.models.Player;
import g43142.zebras.models.Reserve;
import g43142.zebras.models.Species;
import g43142.zebras.view.View;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author dedec
 */
public class Game {
    private List<Player> players;
    private Reserve reserve;
    private ImpalaJones impala;
    private Pieces pieces;
    private GameStatus status;
    private Player currentPlayer;

    /**
     *
     * @param players
     * @param reserve
     * @param impala
     * @param pieces
     * @param status
     * @param currentPlayer
     */
    public Game(List<Player> players, Reserve reserve, ImpalaJones impala,
            Pieces pieces, GameStatus status, Player currentPlayer) {
        this.players = players;
        this.reserve = reserve;
        this.impala = impala;
        this.pieces = pieces;
        this.status = status;
        this.currentPlayer = currentPlayer;
    }
    
    /**
     *Start a match and reset attributes.
     */
    public void start(){
        players = new ArrayList<>();
        reserve = new Reserve();
        impala = new ImpalaJones();
        pieces = new Pieces();      
        
    }
    
    /**
     *Set Impala Jones first position.
     *
     * @param position of Impala Jones at the beginning of game
     * @throws GameException if game's status isn't GameStatus.INIT.
     */
    public void setImpalaJonesFirstPosition(int position)throws GameException{
        if(this.status!=status.INIT){
            throw new GameException();
        }else{
            impala.init(position);
        }
    }
    
    
    public static GameException uneException;
    
    /**
     *Put an animal in the Board. Put an animal of the given species for the
     * current player.
     *
     * @param position position on the board
     * @param species species of an animal
     * @throws GameException if
     * game's status isn't Status.ANIMAL
     * or impala isn't on the same row or column
     * or that the position is not free
     * or the current player doesn't have that a tile of that species to play anymore
     */
    public void putAnimal(Coordinates position, Species species) throws GameException{
        Color color = currentPlayer.getColor();
        if(this.status!=status.ANIMAL || !impala.valid(position) ||
                !reserve.isFree(position) || pieces.getNbAnimal(color, species)==0){
            throw new GameException();
        }else{
            Animal animal = new Animal(species, color);
            reserve.put(animal, position);
        }
    }
    
    /**
     *Move Impala Jones some steps forward.
     *
     * @param distance number of step
     * @throws GameException if
     * game's status isn't Status.IMPALA
     * or impala will arrive on a full row or column
     * or the distance is too large
     */
    public void moveImpalaJones(int distance)throws GameException{
        if(this.status!=status.IMPALA || !impala.checkMove(reserve, distance) ||
                impala.findFirst(reserve)>3){
            throw new GameException();
        }else{
            impala.move(distance);
        }
    }
    
    /**
     *return true if the game is over by checking if any column is free
     * @return true if the game is over
     */
    public boolean isOver(){
        int row=0;
        int col=0;
        boolean itsOK=true;
  
        while(itsOK && row<5 && col<6){
            Coordinates pos = new Coordinates(row, col);
            itsOK = !reserve.freeColumn(pos);
            row++;
            col++;
        }
        return itsOK;
    }
    
    /**
     *return the state of the game
     * @return the state of the game
     */
    public GameStatus getStatus(){
        return status;
    }
    
    /**
     *return the current player
     * @return the current player
     */
    public Color getCurrentColor(){
        return currentPlayer.getColor();
    }
    
    /**
     *return the list of all player
     * @return the list of all player
     */
    public List<Player> getPlayers(){
        return players;
    }
    
    /**
     *return the reserve
     * @return the reserve
     */
    public Reserve getReserve(){
        return reserve;
    }
    
    /**
     *Return the amount of animals of the specified species that the curent
     * player can put in the reserve.
     *
     * @param species of the animal searched
     * @return the amount of animals of the specified species for the current
     * player, left in the stock.
     */
    public int getNb(Species species){
        return pieces.getNbAnimal(currentPlayer.getColor(), species);
    }
    
    /**
     *return impala jones
     * @return impala jones
     */
    public ImpalaJones getImpalaJones(){
        return impala;
    }
    
    /**
     * Get the score of the player of the given color.
     *
     * @param color the color of the player
     * @return the score of the player of the given color.
     */
    public int getScore(Color color){
      //TODO 3eme remise
      return 0;
    }
    
    
    public void play(Model game) throws GameException, IOException {
        System.out.print("Where must Impala Jones start ? \nPlease enter the position : ");
        Scanner sc = new Scanner(System.in);
        int position = sc.nextInt();
        ImpalaJones imp = new ImpalaJones();
        imp.init(position);
        
        while(!game.isOver()){
            System.out.println(View.viewStock(pieces));
            System.out.println(View.viewReserve(reserve));
            
            if(status==status.INIT){
                System.out.print("Initialisation of Impala : ");
                int pos = sc.nextInt();
                imp.init(pos);
            }
            
            if(status==status.ANIMAL){
                System.out.println("Which animal do you want to place ? ");
                String s = sc.next();
                
                Species specie = null;
                if(isGazelle(s)){
                    specie = Species.GAZELLE;
                }if(isCrocodile(s)){
                    specie = Species.CROCODILE;
                }if(isElephant(s)){
                    specie = Species.ELEPHANT;
                }if(isLion(s)){
                    specie = Species.LION;
                }if(isZebre(s)){
                    specie = Species.ZEBRA;
                }else{
                    System.out.println("Try again");
                }
                
                Color color = getCurrentColor();
                Animal animal;
                if(specie==null){
                    throw new GameException();
                }else{
                    animal = new Animal(specie, color);
                }
                
                System.out.println("Where does the"+animal+"needs to be placed ? ");
                System.out.print("row : ");
                int row = sc.nextInt();
                System.out.print("column : ");
                int col = sc.nextInt();
                Coordinates coord = new Coordinates(row, col);
                
                reserve.put(animal, coord);
            }
            
            if(status==status.IMPALA){
                System.out.println("last step of the round : Move Impala");
                System.out.println("(reminder, Impala can only do 3steps max");
                System.out.print("next position : ");
                int pos = sc.nextInt();
                
                while(!sc.hasNextInt()|| pos<0 || pos>3){
                    System.out.println("Try again, wrong number...");
                    pos=sc.nextInt();
                }
                
                imp.move(pos);

            }
            
        }
        
    }
    
    
    public boolean isGazelle(String s){
        String s1 = "gazelle";
        String s2 = "Gazelle";
        String s3 = "GAZELLE";
        String s4 = "gazel";
        String s5 = "gazele";
        String s6 = "g";
        String s7 = "G";
        String s8 = "Gazel";
        String s9 = "Gazele";
        
        return (s.equals(s1) || s.equals(s2) || s.equals(s3) || s.equals(s4) ||
                s.equals(s5) || s.equals(s6) || s.equals(s7) || s.equals(s8) ||
                s.equals(s9) );
        
    }
    
    public boolean isZebre(String s){
        String s1 = "zebre";
        String s2 = "Zebre";
        String s3 = "Zèbre";
        String s4 = "Zebre";
        String s5 = "Z";
        String s6 = "z";
        String s7 = "Zebres";
        String s8 = "Zebra";
        String s9 = "Zebras";
        
        return (s.equals(s1) || s.equals(s2) || s.equals(s3) || s.equals(s4) ||
                s.equals(s5) || s.equals(s6) || s.equals(s7) || s.equals(s8) ||
                s.equals(s9) );
        
    }
    
    public boolean isElephant(String s){
        String s1 = "elephant";
        String s2 = "Elephant";
        String s3 = "Eléphant";
        String s4 = "E";
        String s5 = "e";
        String s6 = "elephants";
        String s7 = "éléphant";
        String s8 = "Éléphant";
        String s9 = "Élephant";
        
        return (s.equals(s1) || s.equals(s2) || s.equals(s3) || s.equals(s4) ||
                s.equals(s5) || s.equals(s6) || s.equals(s7) || s.equals(s8) ||
                s.equals(s9) );
        
    }
    
    public boolean isLion(String s){
        String s1 = "lion";
        String s2 = "Lion";
        String s3 = "lions";
        String s4 = "Lions";
        String s5 = "l";
        String s6 = "L";

        
        return (s.equals(s1) || s.equals(s2) || s.equals(s3) || s.equals(s4) ||
                s.equals(s5) || s.equals(s6) );
        
    }
    
    public boolean isCrocodile(String s){
        String s1 = "crocodile";
        String s2 = "Crocodile";
        String s3 = "croco";
        String s4 = "Croco";
        String s5 = "c";
        String s6 = "C";
        String s7 = "crocodil";
        String s8 = "Crocodil";
        
        return (s.equals(s1) || s.equals(s2) || s.equals(s3) || s.equals(s4) ||
                s.equals(s5) || s.equals(s6) || s.equals(s7) || s.equals(s8));
        
    }
    
    
}
