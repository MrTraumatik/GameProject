package g43142.zebras.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;


/**
 *
 * @author dedec
 */
public class Pieces {
     List<Animal> animals;

    /**
     *Constructor of the list Pieces, containing all the animals avalaible
     */
    public Pieces() {
        animals = new ArrayList<>();
        
        Animal gg = new Animal(Species.GAZELLE, Color.GREEN);
        Animal cg = new Animal(Species.CROCODILE, Color.GREEN);
        Animal eg = new Animal(Species.ELEPHANT, Color.GREEN);
        Animal lg = new Animal(Species.LION, Color.GREEN);
        Animal zg = new Animal(Species.ZEBRA, Color.GREEN);
        
        Animal gr = new Animal(Species.GAZELLE, Color.RED);
        Animal cr = new Animal(Species.CROCODILE, Color.RED);
        Animal er = new Animal(Species.ELEPHANT, Color.RED);
        Animal lr = new Animal(Species.LION, Color.RED);
        Animal zr = new Animal(Species.ZEBRA, Color.RED);
        
        Animal[] ani = {gg, cg, eg, lg, zg, gr, cr, er, lr, zr};
        int[] nbAni = {6, 2, 1, 1, 5, 6, 2, 1, 1, 5};
        for(int i=0;i<ani.length;i++){
            for(int j=0;j<nbAni[i];j++){
                animals.add(ani[i]);
            }
        }
    }       

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.animals);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pieces other = (Pieces) obj;
        if (!Objects.equals(this.animals, other.animals)) {
            return false;
        }
        return true;
    }
    
    /**
     *Get an animal from the list, and remove it
     * @param color the color of the animal
     * @param species the animal's specie
     * @return the animal that will be remove
     */
    public Animal getAnimal(Color color, Species species){
        
        Predicate<Animal> predicat = animals -> animals.getColor().equals(color);
        Predicate<Animal> predSpecie = animals -> animals.getSpecies().equals(species);
        Animal leBon = animals.stream().filter(predicat).filter(predSpecie).findFirst().get();
        
        animals.remove(leBon);
     
        return leBon;    
    }

    /**
     * check if the list is empty, meaning no animals in it
     * @return true if it's empty
     */
    public boolean hasAvailable(){
        return animals.isEmpty();
    }
    
    /**
     * get number of occurences of an animal in the list
     * @param color the color of the animal
     * @param species the animal's specie
     * @return the number of animal left in the list
     */
    public long getNbAnimal(Color color, Species species){
        Predicate<Animal> predicat = animals -> animals.getColor().equals(color);
        Predicate<Animal> predSpecie = animals -> animals.getSpecies().equals(species);
        long cpt = animals.stream().filter(predicat).filter(predSpecie).count();
        return cpt;
        
      
    }

    /**
     *Override of toString Method
     * @return string like : "pieces {animal}"
     */
    @Override
    public String toString() {
        return "Pieces{" + animals + '}';
    }
     
     
    
    
}
