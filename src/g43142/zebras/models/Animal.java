package g43142.zebras.models;

import java.awt.Graphics;

/*
 * Class for creating and changing attributs of animals
 * @author dedec
 */

public class Animal {
    private Species species;
    private Color color;
    private AnimalState state;

    /**
     * Constructor of an animal
     * @param species the specie of the animal
     * @param color the color, to specify to which player the animal belongs
     */
    public Animal(Species species, Color color) {
        this.species = species;
        this.color = color;
    }

    /**
     * Getter of the specie
     * @return the specie of the animal
     */
    public Species getSpecies() {
        return species;       
    }

    /**
     * Getter of the color
     * @return the color of the animal
     */
    public Color getColor() {
        return color;
    }
    
    //ANSI escape codes:
    //permet d'utiliser des couleurs dans l'output.

    /**
     *Reset color (black), use after printing with a color to get back to black.
     */
    public static final String ANSI_RESET = "\u001B[0m";

    /**
     *Red color code (ANSI) 
     */
    public static final String ANSI_RED = "\u001B[31m";

    /**
     *Green color code (ANSI)
     */
    public static final String ANSI_GREEN = "\u001B[32m";
        
    /**
     *Override of toString Method
     * print in color de fisrt letter of an animal with his color
     * @return string of the first char of the animal's name
     */
    @Override
    public String toString() {       
        String string = species.toString();
        String ani= String.valueOf(string.charAt(0));
        if(color==Color.GREEN){
            ani = ANSI_GREEN + ani + ANSI_RESET;            
        }else{
            ani = ANSI_RED + ani + ANSI_RESET;
        }  
        return ani;  
    }
    
    /**
     *return the state of the animal (run, hidden, rest)
     * @return the state of the animal
     */
    public AnimalState getState() {
        return state;
    }
     
    /**
     *
     * @param other
     */
    public void action(Animal other){
         
     }
    
    
}
