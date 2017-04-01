/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g43142.zebras.view;

import g43142.zebras.models.Animal;
import g43142.zebras.models.Color;
import g43142.zebras.models.Coordinates;
import g43142.zebras.models.Pieces;
import g43142.zebras.models.Species;
import g43142.zebras.models.Pieces;
import g43142.zebras.models.Reserve;

/**
 *
 * @author dedec
 */
public class View {
    
    public static String viewStock(Pieces piece){
        int nbG = piece.getNbAnimal(Color.GREEN, Species.GAZELLE);
        int nbZ = piece.getNbAnimal(Color.GREEN, Species.ZEBRA);
        int nbC = piece.getNbAnimal(Color.GREEN, Species.CROCODILE);
        int nbL = piece.getNbAnimal(Color.GREEN, Species.LION);
        int nbE = piece.getNbAnimal(Color.GREEN, Species.ELEPHANT);
        
        return "\n  STOCK\n----------\n" + nbG + " Gazelle(s)\n"
                + nbZ + " Zèbre(s)\n" + nbC + " Corcodile(s)\n" 
                + nbL + " Lion\n" + nbE + " Eléphant";
    }
    
    public static String viewReserve(Reserve res){
        String chaine="";
        
        for(int i =0;i<5;i++){
            for(int j=0;j<6;j++){
                Animal ani = res.getAnimal(new Coordinates(i, j));
                if(ani!=null){
                    chaine = chaine + " " + ani.toString();
                }else{
                    chaine = chaine + " -";
                }
            }
            chaine = chaine + "\n";
        }
        
        return chaine;
    }
    
}
