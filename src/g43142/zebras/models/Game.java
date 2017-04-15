package g43142.zebras.models;

import g43142.zebras.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Game class assembles all the elements of the game already coded. It acts
 * as a facade, meaning that it is only with this class that the view will
 * interact to evolve the game without calling directly the other classes of the
 * model.
 *
 * @author dedec
 */
public class Game implements Model {

    private List<Player> players;
    private Reserve reserve;
    private ImpalaJones impala;
    private Pieces pieces;
    private GameStatus status;
    private Player currentPlayer;

    /**
     * Constructor of a game of "Drôle de Zèbres"
     *
     * @param players list of players of the game
     * @param reserve the board game
     * @param impala Impala Jones
     * @param pieces list of all animals avalaible
     * @param status the game status
     * @param currentPlayer the player who's playing
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
     * Start a match and reset attributes.
     */
    @Override
    public void start() {
        players = new ArrayList<>();
        reserve = new Reserve();
        impala = new ImpalaJones();
        pieces = new Pieces();

    }

    /**
     * Set Impala Jones first position.
     *
     * @param position of Impala Jones at the beginning of game
     * @throws GameException if game's status isn't GameStatus.INIT.
     */
    @Override
    public void setImpalaJonesFirstPosition(int position) throws GameException {
        if (this.status != status.INIT) {
            throw new GameException("status is not INIT");
        } else {
            impala.init(position);
        }
    }

    /**
     * Put an animal in the Board. Put an animal of the given species for the
     * current player.
     *
     * @param position position on the board
     * @param species species of an animal
     * @throws GameException if game's status isn't Status.ANIMAL or impala
     * isn't on the same row or column or that the position is not free or the
     * current player doesn't have that a tile of that species to play anymore
     */
    @Override
    public void putAnimal(Coordinates position, Species species) throws GameException {
        Color color = currentPlayer.getColor();
        if (this.status != status.ANIMAL || !impala.valid(position)
                || !reserve.isFree(position) || pieces.getNbAnimal(color, species) == 0) {
            throw new GameException("problem animal");
        } else {
            Animal animal = new Animal(species, color);
            reserve.put(animal, position);
        }
    }

    /**
     * Move Impala Jones some steps forward.
     *
     * @param distance number of step
     * @throws GameException if game's status isn't Status.IMPALA or impala will
     * arrive on a full row or column or the distance is too large
     */
    @Override
    public void moveImpalaJones(int distance) throws GameException {
        if (this.status != status.IMPALA || !impala.checkMove(reserve, distance)
                || impala.findFirst(reserve) > 3) {
            throw new GameException("problem impala");
        } else {
            impala.move(distance);
        }
    }

    /**
     * return true if the game is over by checking if any column is free
     *
     * @return true if the game is over
     */
    @Override
    public boolean isOver() {
        int col = 0;
        boolean itsOK = true;

        while (itsOK && col < 6) {
            itsOK = !reserve.freeColumn(col);
            col++;
        }
        return itsOK;
    }

    /**
     * return the state of the game
     *
     * @return the state of the game
     */
    @Override
    public GameStatus getStatus() {
        return status;
    }

    /**
     * return the current player
     *
     * @return the current player
     */
    @Override
    public Color getCurrentColor() {
        return currentPlayer.getColor();
    }

    /**
     * return the list of all player
     *
     * @return the list of all player
     */
    @Override
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * return the reserve
     *
     * @return the reserve
     */
    @Override
    public Reserve getReserve() {
        return reserve;
    }

    /**
     * Return the amount of animals of the specified species that the curent
     * player can put in the reserve.
     *
     * @param species of the animal searched
     * @return the amount of animals of the specified species for the current
     * player, left in the stock.
     */
    @Override
    public int getNb(Species species) {
        return pieces.getNbAnimal(currentPlayer.getColor(), species);
    }

    /**
     * return impala jones
     *
     * @return impala jones
     */
    @Override
    public ImpalaJones getImpalaJones() {
        return impala;
    }

    /**
     * Get the score of the player of the given color.
     *
     * @param color the color of the player
     * @return the score of the player of the given color.
     */
    public int getScore(Color color) {
        //TODO 3eme remise
        return 0;
    }

    /**
     * Interactions with the players are made here : changing turns ; placing
     * animals etc...
     *
     * @param game the model with all the parameters needed to play
     * @throws GameException if a problem occurs while playing
     */
    public void play(Model game) throws GameException {
        Scanner sc = new Scanner(System.in);
        boolean playerOne = true;
        Player p1 = new Player(Color.GREEN);
        Player p2 = new Player(Color.RED);
        System.out.println("*=============*\nDrôle de Zèbres !\n*=============*");
        System.out.println("here's a reminder of the rules :");
        System.out.println("https://elearning.esi.heb.be/courses/DEV2/document/projet/regles-ddz.pdf");
        System.out.print("Where must Impala Jones start : ");
        int position = sc.nextInt();
        /**
        System.out.println("What's the game status ?");
        System.out.println("1 : INIT\n2 : ANIMAL\n3 : IMPALA");
        int stat = sc.nextInt();
        intToStat(stat);
        */
        status=status.INIT;
        setImpalaJonesFirstPosition(position);

        while (!isOver()) {
            if (playerOne) {
                currentPlayer = p1;
                turnActions();
            } else {
                currentPlayer = p2;
                turnActions();
            }
            playerOne = !playerOne;
        }

    }

    /**
     * Actions that need to be made while the game status is INIT
     *
     */
    public void actionInitState() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Initialisation of Impala : ");
        int pos = sc.nextInt();
        impala.init(pos);
        System.out.println(View.viewStock(pieces));
        System.out.println(View.viewReserve(reserve));
    }

    /**
     * Actions that need to be made while the game status is ANIMAL Player must
     * place an animal from his stock on the reserve (conditions are in method :
     * putAnimal)
     *
     * @throws GameException if the player can't put the animal
     */
    public void actionAnimalState() throws GameException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Which animal do you want to place ? ");
        String s = sc.next();

        Species specie = null;
        if (isGazelle(s)) {
            specie = Species.GAZELLE;
        } else if (isCrocodile(s)) {
            specie = Species.CROCODILE;
        } else if (isElephant(s)) {
            specie = Species.ELEPHANT;
        } else if (isLion(s)) {
            specie = Species.LION;
        } else if (isZebre(s)) {
            specie = Species.ZEBRA;
        } else {
            System.out.println("Try again");
            //something to repeat ....
        }

        Color color = getCurrentColor();
        Animal animal;
        if (specie == null) {
            throw new GameException("no specie");
        } else {
            animal = pieces.getAnimal(color, specie);
        }

        int row, col;
        System.out.println("Where does the " + animal
                + " needs to be placed ? ");
        if (impala.isUp() || impala.isDown()) {
            System.out.print("row : ");
            row = sc.nextInt();
            col = impala.getColumn();
        } else {
            System.out.print("column : ");
            col = sc.nextInt();
            row = impala.getRow();
        }
        Coordinates coord = new Coordinates(row, col);
        putAnimal(coord, specie);
        System.out.println(View.viewStock(pieces));
        System.out.println(View.viewReserve(reserve));
    }

    /**
     * Actions that need to be made while the game status is IMPALA The player
     * must move Impala (condition of the movement are in movImpalaJones)
     *
     * @throws GameException if the movement isn't possible
     */
    public void actionImpalaState() throws GameException {

        Scanner sc = new Scanner(System.in);
        System.out.println("last step of the round : Move Impala");
        System.out.println("(reminder, Impala can only do 3steps max");
        System.out.print("next position : ");
        int pos = sc.nextInt();
        
        while (pos < 0 || pos > 3) {
            System.out.println("Try again, wrong number...");
            pos = sc.nextInt();
        }
       
        moveImpalaJones(pos);
        //System.out.println(View.viewStock(pieces));
        System.out.println(View.viewReserve(reserve));
    }

    /**
     * Change the status of the game to the next one 
     * Switch status like this :
     * init becomes animal
     * animal becomes impala
     * impala becomes init
     *
     */
    public void newStatus() {
        /**
        Scanner sc = new Scanner(System.in);
        System.out.print("enter new game status : ");
        int stat = sc.nextInt();
        switch (stat) {
            case 1:
                status = status.INIT;
                break;
            case 2:
                status = status.ANIMAL;
                break;
            case 3:
                status = status.IMPALA;
                break;
        }
        */
        if(status==status.INIT){
            status=status.ANIMAL;
        }else if(status==status.ANIMAL){
            status=status.IMPALA;
        }else if(status==status.IMPALA){
            status=status.INIT;
        }
        
    }

    /**
     * Method to clarify when a specific action must be used Exemple : init
     * state use the init actions, and not the animal actions
     *
     * @throws GameException for animal actions or impala actions
     */
    public void turnActions() throws GameException {
        System.out.println(View.viewStock(pieces));
        System.out.println(View.viewReserve(reserve));
        /**
        if (status == status.INIT) {
            actionInitState();
        }
        * */
        newStatus();
        if (status == status.ANIMAL) {
            actionAnimalState();
        }
        newStatus();
        if (status == status.IMPALA) {
            actionImpalaState();
        }
        newStatus();
    }

    /**
     * Check if the string entered by the player is supposed to be GAZELLE
     *
     * @param s the string entered by the player
     * @return true if it's supposed to be a gazelle
     */
    public boolean isGazelle(String s) {
        String s1 = "gazelle";
        String s2 = "Gazelle";
        String s3 = "GAZELLE";
        String s4 = "gazel";
        String s5 = "gazele";
        String s6 = "g";
        String s7 = "G";
        String s8 = "Gazel";
        String s9 = "Gazele";

        return (s.equals(s1) || s.equals(s2) || s.equals(s3) || s.equals(s4)
                || s.equals(s5) || s.equals(s6) || s.equals(s7) || s.equals(s8)
                || s.equals(s9));

    }

    /**
     * Check if the string entered by the player is supposed to be ZEBRE
     *
     * @param s the string entered by the player
     * @return true if it's supposed to be a zebra
     */
    public boolean isZebre(String s) {
        String s1 = "zebre";
        String s2 = "Zebre";
        String s3 = "Zèbre";
        String s4 = "Zebre";
        String s5 = "Z";
        String s6 = "z";
        String s7 = "Zebres";
        String s8 = "Zebra";
        String s9 = "Zebras";

        return (s.equals(s1) || s.equals(s2) || s.equals(s3) || s.equals(s4)
                || s.equals(s5) || s.equals(s6) || s.equals(s7) || s.equals(s8)
                || s.equals(s9));

    }

    /**
     * Check if the string entered by the player is supposed to be ELEPHANT
     *
     * @param s the string entered by the player
     * @return true if it's supposed to be an elephant
     */
    public boolean isElephant(String s) {
        String s1 = "elephant";
        String s2 = "Elephant";
        String s3 = "Eléphant";
        String s4 = "E";
        String s5 = "e";
        String s6 = "elephants";
        String s7 = "éléphant";
        String s8 = "Éléphant";
        String s9 = "Élephant";

        return (s.equals(s1) || s.equals(s2) || s.equals(s3) || s.equals(s4)
                || s.equals(s5) || s.equals(s6) || s.equals(s7) || s.equals(s8)
                || s.equals(s9));

    }

    /**
     * Check if the string entered by the player is supposed to be LION
     *
     * @param s the string entered by the player
     * @return true if it's supposed to be a lion
     */
    public boolean isLion(String s) {
        String s1 = "lion";
        String s2 = "Lion";
        String s3 = "lions";
        String s4 = "Lions";
        String s5 = "l";
        String s6 = "L";

        return (s.equals(s1) || s.equals(s2) || s.equals(s3) || s.equals(s4)
                || s.equals(s5) || s.equals(s6));

    }

    /**
     * Check if the string entered by the player is supposed to be CROCODILE
     *
     * @param s the string entered by the player
     * @return true if it's supposed to be a crocodile
     */
    public boolean isCrocodile(String s) {
        String s1 = "crocodile";
        String s2 = "Crocodile";
        String s3 = "croco";
        String s4 = "Croco";
        String s5 = "c";
        String s6 = "C";
        String s7 = "crocodil";
        String s8 = "Crocodil";

        return (s.equals(s1) || s.equals(s2) || s.equals(s3) || s.equals(s4)
                || s.equals(s5) || s.equals(s6) || s.equals(s7) || s.equals(s8));

    }

}
