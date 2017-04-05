package g43142.zebras.view;

import g43142.zebras.models.Animal;
import g43142.zebras.models.Color;
import g43142.zebras.models.Coordinates;
import g43142.zebras.models.Species;
import g43142.zebras.models.Pieces;
import g43142.zebras.models.Reserve;

/**
 * View class to improve the prompting of the board game or the stock.
 *
 * @author dedec
 */
public class View {

    /**
     * Change the way a stock is printed
     *
     * @param piece the list of animal
     * @return a new string of how many animals are left in the list
     */
    public static String viewStock(Pieces piece) {
        int nbG = piece.getNbAnimal(Color.GREEN, Species.GAZELLE);
        int nbZ = piece.getNbAnimal(Color.GREEN, Species.ZEBRA);
        int nbC = piece.getNbAnimal(Color.GREEN, Species.CROCODILE);
        int nbL = piece.getNbAnimal(Color.GREEN, Species.LION);
        int nbE = piece.getNbAnimal(Color.GREEN, Species.ELEPHANT);

        return "\n  STOCK\n----------\n" + nbG + " Gazelle(s)\n"
                + nbZ + " Zèbre(s)\n" + nbC + " Corcodile(s)\n"
                + nbL + " Lion\n" + nbE + " Eléphant\n";
    }

    /**
     * Change the way the board game is printed
     *
     * @param res the reserve of animals
     * @return a new string shapped like a table
     */
    public static String viewReserve(Reserve res) {
        String chaine = "         RESERVE\n*-------------------*\n| ";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                Animal ani = res.getAnimal(new Coordinates(i, j));
                if (ani != null) {
                    chaine = chaine + " " + ani.toString();
                } else {
                    chaine = chaine + " -";
                }
                chaine = chaine + "|";
            }
            chaine = chaine + " \n|------------------|\n| ";
        }
        //if(chaine.endsWith("|")){
        chaine = chaine.substring(0, chaine.length()-1);
        //}
        chaine = chaine + "\n*-------------------*";
        return chaine;
    }

}
