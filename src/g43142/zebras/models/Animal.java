package g43142.zebras.models;

/*
 * Représente les différents animaux disponibles.
 */

/**
 *
 * @author dedec
 */
public class Animal {
    Species species;
    Color color;

    /**
     * Constructeur de la classe
     * @param species désigne l'espèce
     * @param color désigne le joueur à qui elle appartient
     */
    public Animal(Species species, Color color) {
        this.species = species;
        this.color = color;
    }

    /**
     * Getteur pour l'espèce
     * @return
     */
    public Species getSpecies() {
        return species;       
    }

    /**
     * Getteur pour la couleur
     * @return
     */
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Animal{" + "species=" + species + ", color=" + color + '}';
    }
    
    
}
