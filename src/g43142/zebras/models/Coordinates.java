package g43142.zebras.models;

/*
 * Structure des coordonnées, simulée via cette classe.
 * La classe représente les coordonnées des cases de la réserve d'animaux.
 * @author dedec
 */

public class Coordinates {
    
    private int row;
    private int column;
    
     /**
     * Constructeur de coordonnées
     * @param row indique la ligne
     * @param column indique la colonne
     */
    public Coordinates(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Getter de la valeur de la ligne
     * @return la valeur de la ligne
     */
    public int getRow() {
        return row;
    }

    /**
     * Getter de la valeur de la colonne
     * @return la valeur de la colonne
     */
    public int getColumn() {
        return column;
    }
}
