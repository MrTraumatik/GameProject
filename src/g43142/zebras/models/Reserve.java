package g43142.zebras.models;

/*
 * Creation of the board game with a 2D Array
 * The reserve is surrounded by a trail where Impala Jones moves 
 * 30 cases total (5x6).
 * @author dedec
 */
import java.util.Arrays;

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
     * @param pos row and column 
     * @return false if an animal is on the case, true if not
     */
    public boolean isFree(Coordinates pos){
        return reserve[pos.getRow()][pos.getColumn()]== null;
    }
    
    
    
    
    
    
    
    
    
    
    
    /**
     * Insert the animal in the case
     * @param animal the animal to put in
     * @param pos the position where the animal need to be
     */
    public void put(Animal animal, Coordinates pos){
        //si la coordonnée de la case n'est pas dans la réserve 
        // ET qu'il n'y a pas d'animal déjà présent sur cette case.
        if((pos.getColumn()<0)&& (pos.getColumn()>NBCOLS)
                &&(pos.getRow()<0)&&(pos.getRow()>NBROWS)){
            throw new ArrayIndexOutOfBoundsException () ;
        }
        if(isFree(pos)){
            reserve[pos.getRow()][pos.getColumn()]= animal;
           
        }            
                 
    }
    
    public boolean isInside(Coordinates pos){
        return (pos.getColumn()>0)&& (pos.getColumn()<NBCOLS)
                &&(pos.getRow()>0)&&(pos.getRow()<NBROWS);
    }
    
    
    
    
    
    
    
    
    
    
    
    /**
     * Getter for the animal
     * @param pos the animal's position
     * @return the animal who's on the case
     */
    public Animal getAnimal(Coordinates pos){
        return reserve[pos.getRow()][pos.getColumn()];
    }
    
    

    
    /**
     * Extra method to print the coordinates as a String 
     * @param pos the row and the column
     * @return a String like this : [row][column]
     */
    public String getCoordinates(Coordinates pos){
        return "[" + (pos.getRow()+1) + "]" + "[" + (pos.getColumn()+1) + "]";
    } 


    
    @Override
    public String toString(){
         String chaine="";
        
        for(int i =0;i<NBROWS;i++){
            for(int j=0;j<NBCOLS;j++){
                Animal ani = getAnimal(new Coordinates(i, j));
                if(ani!=null){
                    chaine = chaine + " " + ani.toString();
                }else{
                    chaine = chaine + " -";
                }
            }
            chaine = chaine + "\n";
        }
        
        return chaine;

         //return Arrays.deepToString(reserve).replaceAll("],", "]\n");
         //le deepToString pour afficher le tableau en entier sur une ligne
         //le replaceAll pour aller à la ligne à chaque fin de lignes du tableau
         //replaceAll change les '],' en ']\n'
    }

    public boolean freeColumn(Coordinates pos){
        int nbNull = 0;
        int row = 0;
        while(nbNull==0 && row<4){
            if(reserve[row][pos.getColumn()]==null){
                nbNull=nbNull+1;
            }
            row++;
        }
        return nbNull!=0;
    }
   
    public boolean freeRow(Coordinates pos){
        int nbNull = 0;
        int col = 0;
        while(nbNull==0 && col<5){
            if(reserve[pos.getRow()][col]==null){
                nbNull=nbNull+1;
            }
            col++;
        }
        return nbNull!=0;
    }
    
    
    
    
    
    
    
    
    
}
