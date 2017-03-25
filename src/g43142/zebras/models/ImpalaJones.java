/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g43142.zebras.models;

/**
 *
 * @author Richard
 */
public class ImpalaJones {
    int position; 

    public ImpalaJones() {
        position = -1;
    }

    public int getPosition() {
        return position;
    }
    
    public void init(int nb){
        position = nb;
    }
    
    public void move(int distance){
        position = position + distance;
    }
    
    public boolean isUp(){
        return (position>0&&position<6);
    }
    
    public boolean isDown(){
        return (position>10&&position<17);
    }
    
    public boolean isRight(){
        return (position>5&&position<11);
    }
    
    public boolean isLeft(){
        return (position>16&&position<22);
    }
    
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
    
    public boolean valid(Coordinates pos){
        return pos.getColumn()== getColumn() || pos.getRow()== getRow() ;
    }
    
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

