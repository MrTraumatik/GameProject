package g43142.zebras.models;

/*
 * Structure des coordonnées, simulée via cette classe.
 * La classe représente les coordonnées des cases de la réserve d'animaux.
 */

/**
 *
 * @author dedec
 */
public class Coordinates {
    
    private int row;

    /**
     * Get the value of row
     * @return the value of row
     */
    public int getRow() {
        return row;
    }

    private int column;

    /**
     * Get the value of column
     * @return the value of column
     */
    public int getColumn() {
        return column;
    }

    /**
     * Constructeur de coordonnées
     * @param row
     * @param column
     */
    public Coordinates(int row, int column) {
        this.row = row;
        this.column = column;
    }

}
