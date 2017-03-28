package g43142.zebras.models;

/**
 *
 * @author Richard
 */
public class ImpalaJones {
    int position; 

    /**
     *Constructor of Impala Jones
     * set position to -1 (out of his path)
     */
    public ImpalaJones() {
        position = -1;
    }

    /**
     *Getter of his position
     * @return
     */
    public int getPosition() {
        return position;
    }
    
    /**
     * Set his position to a number
     * @param nb the position impala jones needs to be
     */
    public void init(int nb){
        position = nb;
    }
    
    /**
     *Move impala jones from his position to a new one
     * @param distance the distance to his new position
     */
    public void move(int distance){
        position = position + distance;
    }
    
    /**
     *check if impala is on the top side
     * @return true if impala is upside
     */
    public boolean isUp(){
        return (position>0&&position<6);
    }
    
    /**
     *check if impala is on the down side
     * @return true if impala is downside
     */
    public boolean isDown(){
        return (position>10&&position<17);
    }
    
    /**
     *check if impala is on the right side
     * @return true if impala is on the right
     */
    public boolean isRight(){
        return (position>5&&position<11);
    }
    
    /**
     *check if impala is on the left side
     * @return true if impala is on the left
     */
    public boolean isLeft(){
        return (position>16&&position<22);
    }
    
    /**
     *Getter of the column corresponding of impala's position
     * @return the column where impala can put animals
     */
    public int getColumn(){
        int col=-1;
        if(isUp()){
            col = getPosition();
        }
        if(isDown()){
            col = 16 - getPosition();
        }
        return col;
    }
    
    /**
     *Getter of the row corresponding of impla's position
     * @return the row where impala can put animals
     */
    public int getRow(){
        int row = -1;
        if(isRight()){
            row = getPosition()-6;
        }
        if(isLeft()){
            row = 21 - getPosition();
        }
        return row;
    }
    
    /**
     *Check if impala's next move can be done
     * meaning if the row or column where he will be has still a free case 
     * @param reserve the reserve of animals
     * @param distance the next move wanted
     * @return true if the move is ok
     */
    public boolean checkMove(Reserve reserve, int distance){
        boolean freeRow;
        boolean freeColumn;
        move(distance);

        int row = getRow();
        int col = getColumn();
        
        Coordinates pos = new Coordinates(row, col);
        
        freeRow=reserve.freeRow(pos);
        freeColumn=reserve.freeColumn(pos);
        
        return freeRow || freeColumn;
           
    }
    
    /**
     *check if the position of impala is the same as the position in the parameters
     * @param pos the position where impala is supposed to be
     * @return if impala is at this position
     */
    public boolean valid(Coordinates pos){
        return pos.getColumn()== getColumn() || pos.getRow()== getRow() ;
    }
    
    /**
     *Find the first case where impala can go
     * meaning : if the next row or column isn't free, impala can't go there
     * @param reserve the reserve of animals
     * @return the first deplacement possible for impala
     */
    public int findFirst(Reserve reserve){
        int deplacement = 0;
        int row = getRow();
        int col = getColumn();
        Coordinates pos = new Coordinates(row+1, col+1);
        while(!reserve.freeColumn(pos)&& !reserve.freeRow(pos)){
            row++;
            col++;
            deplacement++;
        }
        return deplacement;
    }
    
    
}

