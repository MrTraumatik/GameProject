package g43142.zebras.models;

/*
 * Coordinate's structure, with row and columns
 * @author dedec
 */

public class Coordinates {
    
    private final int ROW;
    private final int COLUMN;
    
     /**
     * Constructor of coordinates
     * @param row the row of the case
     * @param column the column of the case
     */
    public Coordinates(int row, int column) {
        this.ROW = row;
        this.COLUMN = column;
    }

    /**
     * Getter of the value of the row
     * @return the value of the row
     */
    public int getRow() {
        return ROW;
    }

    /**
     * Getter of the value of the column
     * @return the value of the column
     */
    public int getColumn() {
        return COLUMN;
    }
}
