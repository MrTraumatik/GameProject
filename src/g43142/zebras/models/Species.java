package g43142.zebras.models;

/*
 * Enumération des espèces disponibles.
 * La valeur indiquée représente la capacité de l'animal à attirer
 * les touristes. Plus elle est élevée, plus l'attirance est forte!
 * @author dedec
 */

public enum Species {
    /**
     * c'est une gazelle! 
     * 6pions, valeur 2
     */
    GAZELLE, 
    /**
     * c'est un zèbre! Attraction principale de la réserve.
     * 5pions, valeur 6
     */
    ZEBRA, 
    /**
     * c'est un lion!
     * 1pion, valeur 1
     */
    LION, 
    /**
     * c'est un éléphant!
     * 1pion, valeur 5
     */
    ELEPHANT, 
    /**
     * c'est un crocodile!
     * 2pions, valeur 0
     */
    CROCODILE;
}
