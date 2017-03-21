package g43142.zebras.models;

/*
 * La classe Reserve représente le plateau de jeu via un tableau 2D.
 * 30 cases en total (5x6).
 * La réserve est entourée d'une piste où se déplace Impala Jones!
 * @author dedec
 */
import java.util.Arrays;

public class Reserve {
    
    static private final int NBROWS = 4;
    static private final int NBCOLS = 5;
    private final Animal[][] reserve;

    /**
     * Constructeur d'une réserve, sans paramètres
     */
    public Reserve() {
        reserve = new Animal[NBROWS][NBCOLS]; 
    }
    
    /**
     * Indique si une case est vide ou non
     * @param pos la ligne et la colonne dont on veut connaitre la disponibilité
     * @return vrai si la case est vide, faux sinon
     */
    public boolean isFree(Coordinates pos){
        return reserve[pos.getRow()][pos.getColumn()]== null;
    }
    
    /**
     * Insère un animal dans une des cases du plateau
     * @param animal l'animal à placer
     * @param pos la position voulue
     */
    public void put(Animal animal, Coordinates pos){
        try{
            if((pos.getColumn()>=0)&&(pos.getColumn()<NBCOLS)
                    &&(pos.getRow()>=0)&&(pos.getRow()<NBROWS)){
                reserve[pos.getRow()][pos.getColumn()]= animal;
            }
        }catch(NullPointerException e){
            System.out.println("coordonnée est null");   
        }         
    }
    
    /**
     * Getteur pour l'animal
     * @param pos la position de l'animal
     * @return l'animal qui se trouve sur le case rentrée en paramètre
     */
    public Animal getAnimal(Coordinates pos){
        return reserve[pos.getRow()][pos.getColumn()];
        
        //int r = pos.getRow();
        //int c = pos.getColumn();
        //Species uneEspece = reserve[r][c].getSpecies(); 
        //Color uneCouleur = reserve[r][c].getColor();
        //Animal unAnimal = new Animal(uneEspece, uneCouleur);
        //return unAnimal;
    }
    
    /**
     * Affichage des coordonnées plus clair 
     * @param pos la ligne et la colonne
     * @return une chaine indiquant la ligne et la colonne
     */
    public String getCoordinates(Coordinates pos){
        return "[" + (pos.getRow()+1) + "]" + "[" + (pos.getColumn()+1) + "]";
    } 

    @Override
    public String toString(){
         return Arrays.deepToString(reserve).replaceAll("],", "]\n");
         //le deepToString pour afficher le tableau en entier?
         //le replaceAll pour aller à la ligne à chaque fin de lignes du tableau
    }
   
    


}
