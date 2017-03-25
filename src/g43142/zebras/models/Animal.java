package g43142.zebras.models;

/*
 * Class for creating and changing attributs of animals
 * @author dedec
 */

public class Animal {
    Species species;
    Color color;

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
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
        
    @Override
    public String toString() {       
        String finalString;
        if(color==Color.GREEN){
            finalString = ANSI_GREEN + species + ANSI_RESET;
        }else{
            finalString = ANSI_RED + species + ANSI_RESET;
        }
        return finalString;
    }
    
    
}
