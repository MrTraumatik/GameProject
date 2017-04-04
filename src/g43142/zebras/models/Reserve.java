package g43142.zebras.models;

/*
 * Creation of the board game with a 2D Array
 * The reserve is surrounded by a trail where Impala Jones moves 
 * 30 cases total (5x6).
 *
 * @author dedec
 */
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Richard
 */
public class Reserve {

    static private final int NBROWS = 5;
    static private final int NBCOLS = 6;
    private final Animal[][] reserve;

    /**
     * Constructor of the board game named 'reserve' without parameters needed
     */
    public Reserve() {
        reserve = new Animal[NBROWS][NBCOLS];
    }

    /**
     * Say (false or true) if an animal is in the case or not
     *
     * @param pos row and column
     * @return false if an animal is on the case, true if not
     */
    public boolean isFree(Coordinates pos) {
        return reserve[pos.getRow()][pos.getColumn()] == null;
    }

    /**
     * Insert the animal in the case
     *
     * @param animal the animal to put in
     * @param pos the position where the animal need to be
     */
    public void put(Animal animal, Coordinates pos) {
        //si la coordonnée de la case n'est pas dans la réserve 
        // ET qu'il n'y a pas d'animal déjà présent sur cette case.
        if ((pos.getColumn() < 0) && (pos.getColumn() > NBCOLS)
                && (pos.getRow() < 0) && (pos.getRow() > NBROWS)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (isFree(pos)) {
            reserve[pos.getRow()][pos.getColumn()] = animal;

        }

    }

    /**
     * Check if the coordinate is inside the reserve
     *
     * @param pos row and column of the case that will be checked
     * @return true if it's inside the reserve
     */
    public boolean isInside(Coordinates pos) {
        return (pos.getColumn() > 0) && (pos.getColumn() < NBCOLS)
                && (pos.getRow() > 0) && (pos.getRow() < NBROWS);
    }

    /**
     * Getter for the animal
     *
     * @param pos the animal's position
     * @return the animal who's on the case
     */
    public Animal getAnimal(Coordinates pos) {
        return reserve[pos.getRow()][pos.getColumn()];
    }

    /**
     * Override of toString Method change the print by creating one big string
     * of - if there's no animal and the first letter of the animal if he's on
     * the case
     *
     * @return a string shape like a table with '-' or the first letter of an
     * animal.
     */
    @Override
    public String toString() {
        String chaine = "";

        for (int i = 0; i < NBROWS; i++) {
            for (int j = 0; j < NBCOLS; j++) {
                Animal ani = getAnimal(new Coordinates(i, j));
                if (ani != null) {
                    chaine = chaine + " " + ani.toString();
                } else {
                    chaine = chaine + " -";
                }
            }
            chaine = chaine + "\n";
        }

        return chaine;
    }

    /**
     * Check if the column of the coordinate has at least one free case where an
     * animal can be placed
     *
     * @param col the column of the position
     * @return true if the column has at least one free spot
     */
    public boolean freeColumn(int col) {
        int nbNull = 0;
        int row = 0;
        while (nbNull == 0 && row < 5) {
            if (reserve[row][col] == null) {
                nbNull++;
            }
            row++;
        }
        return nbNull != 0;
    }

    /**
     * Check if the row of the coordinate has at least one free case where an
     * animal can be placed
     *
     * @param row the row of the position
     * @return true if the row has at least one free spot
     */
    public boolean freeRow(int row) {
        int nbNull = 0;
        int col = 0;
        while (nbNull == 0 && col < 6) {
            if (reserve[row][col] == null) {
                nbNull = nbNull + 1;
            }
            col++;
        }
        return nbNull != 0;
    }

    /**
     * Return a list of all case next to the position (up, down, left and right)
     *
     * @param pos the row and the column
     * @return the list of case next to the position
     */
    public List<Coordinates> getAdjacents(Coordinates pos) {
        List<Coordinates> list = new ArrayList<>();
        int row = pos.getRow();
        int col = pos.getColumn();

        Coordinates posUP = new Coordinates(row - 1, col);
        Coordinates posDown = new Coordinates(row + 1, col);
        Coordinates posRight = new Coordinates(row, col + 1);
        Coordinates posLeft = new Coordinates(row, col - 1);

        if (!isUP(pos)) {
            list.add(posUP);
        }
        if (!isDown(pos)) {
            list.add(posDown);
        }
        if (!isLeft(pos)) {
            list.add(posLeft);
        }
        if (!isRight(pos)) {
            list.add(posRight);
        }
        return list;
    }

    /**
     * check if the position given is on the border of the reserve
     *
     * @param pos the position that needs to be checked
     * @return true if it's on the border
     */
    public boolean isBorder(Coordinates pos) {
        return pos.getColumn() == 0 || pos.getColumn() == 5
                || pos.getRow() == 0 || pos.getRow() == 4;
    }

    /**
     * check if the position given is on the top side
     *
     * @param pos the position that needs to be checked
     * @return true if it's on top
     */
    public boolean isUP(Coordinates pos) {
        return pos.getRow() == 0;
    }

    /**
     * check if the position given is on the down side
     *
     * @param pos the position that needs to be checked
     * @return true if it's down side
     */
    public boolean isDown(Coordinates pos) {
        return pos.getRow() == 4;
    }

    /**
     * check if the position given is on the right side
     *
     * @param pos the position that needs to be checked
     * @return true if it's on the right
     */
    public boolean isRight(Coordinates pos) {
        return pos.getColumn() == 5;
    }

    /**
     * check if the position given is on the left side
     *
     * @param pos the position that needs to be checked
     * @return true if it's on the left
     */
    public boolean isLeft(Coordinates pos) {
        return pos.getColumn() == 0;
    }

}
