package g43142.zebras.models;

/**
 * Creation of Impala Jones
 *
 * @author Richard
 */
public class ImpalaJones {

    //private static final int MINRANGE = 0;
    //private static final int MAXRANGE = 21;
    //@Range(min=MINRANGE, max=MAXRANGE)
    private int position;

    /**
     * Constructor of Impala Jones set position to -1 (out of his path)
     */
    public ImpalaJones() {
        if (position < 0 || position > 21) {
            throw new IllegalArgumentException();
        } else {
            position = -1;
        }
    }

    /**
     * Getter of his position
     *
     * @return
     */
    public int getPosition() {
        return position;
    }

    /**
     * Set his position to a number
     *
     * @param nb the position impala jones needs to be
     */
    public void init(int nb) {
        position = nb;
    }

    /**
     * Move impala jones from his position to a new one
     *
     * @param distance the distance to his new position
     */
    public void move(int distance) {
        position = position + distance;
    }

    /**
     * check if impala is on the top side
     *
     * @return true if impala is upside
     */
    public boolean isUp() {
        return (position >= 0 && position < 6);
    }

    /**
     * check if impala is on the down side
     *
     * @return true if impala is downside
     */
    public boolean isDown() {
        return (position > 10 && position < 17);
    }

    /**
     * check if impala is on the right side
     *
     * @return true if impala is on the right
     */
    public boolean isRight() {
        return (position > 5 && position < 11);
    }

    /**
     * check if impala is on the left side
     *
     * @return true if impala is on the left
     */
    public boolean isLeft() {
        return (position > 16 && position < 22);
    }

    /**
     * Getter of the column corresponding of impala's position
     *
     * @return the column where impala can put animals
     */
    public int getColumn() {

        if (isUp()) {
            return getPosition();
        }
        if (isRight()) {
            return -1;
        }
        if (isDown()) {
            return 16 - getPosition();
        } else {
            return -1;
        }

    }

    /**
     * Getter of the row corresponding of impla's position
     *
     * @return the row where impala can put animals
     */
    public int getRow() {
        int row = -1;
        if (isRight()) {
            row = getPosition() - 6;
        }
        if (isLeft()) {
            row = 21 - getPosition();
        }
        return row;
    }

    /**
     * Check if impala's next move can be done meaning if the row or column
     * where he will be has still a free case
     *
     * @param reserve the reserve of animals
     * @param distance the next move wanted
     * @return true if the move is ok
     */
    public boolean checkMove(Reserve reserve, int distance) {
        move(distance);
        int row = getRow();
        int col= getColumn();
       
        if (position > 21) {
            if (position == 22) {
                position = 0;
                row = getRow();
                col= getColumn();
            }
            if (position == 23) {
                position = 1;
                row = getRow();
                col= getColumn();
            }
            if (position == 24) {
                position = 2;
                row = getRow();
                col= getColumn();
            }
            if (position == 25) {
                position = 3;
                row = getRow();
                col= getColumn();
            }
            if (position == 26) {
                position = 4;
                row = getRow();
                col= getColumn();
            }
            if (position == 27) {
                position = 5;
                row = getRow();
                col= getColumn();
            }
        }
        if (row == -1) {
            move(-distance);
            return reserve.freeColumn(col);
        } else {
            move(-distance);
            return reserve.freeRow(row);
        }
    }

    /**
     * check if the position of impala is the same as the position in the
     * parameters
     *
     * @param pos the position where impala is supposed to be
     * @return if impala is at this position
     */
    public boolean valid(Coordinates pos) {
        return pos.getColumn() == getColumn() || pos.getRow() == getRow();
    }

    /**
     * Find the first case where impala can go meaning : if the next row or
     * column isn't free, impala can't go there
     *
     * @param reserve the reserve of animals
     * @return the first deplacement possible for impala
     */
    public int findFirst(Reserve reserve) throws GameException{

        int move = 0;
        while(!checkMove(reserve, move)){
            if(move>9){
                throw new GameException();
            }else{
                move++; 
            }
        }
        return move;
    }
}
