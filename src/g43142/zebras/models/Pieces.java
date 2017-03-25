/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public Pieces() {
        animals = new ArrayList<Animal>();
        
        Animal gg = new Animal(Species.GAZELLE, Color.GREEN);
        Animal cg = new Animal(Species.CROCODILE, Color.GREEN);
        Animal eg = new Animal(Species.ELEPHANT, Color.GREEN);
        Animal lg = new Animal(Species.LION, Color.GREEN);
        Animal zg = new Animal(Species.ZEBRA, Color.GREEN);
        
        int n = 0;
        while(n<6){
            animals.add(gg);
            n++;
        }
        n = 0;
        while(n<5){
            animals.add(zg);
            n++;
        }
        n = 0;
        while(n<2){
            animals.add(cg);
            n++;
        }
        animals.add(eg);
        animals.add(lg);
        
        Animal gr = new Animal(Species.GAZELLE, Color.RED);
        Animal cr = new Animal(Species.CROCODILE, Color.RED);
        Animal er = new Animal(Species.ELEPHANT, Color.RED);
        Animal lr = new Animal(Species.LION, Color.RED);
        Animal zr = new Animal(Species.ZEBRA, Color.RED);
        
        n = 0;
        while(n<6){
            animals.add(gr);
            n++;
        }
        n = 0;
        while(n<5){
            animals.add(zr);
            n++;
        }
        n = 0;
        while(n<2){
            animals.add(cr);
            n++;
        }
        animals.add(er);
        animals.add(lr);
        
        
            
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.animals);
        return hash;
    }

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
    
    public Animal getAnimal(Color color, Species species){
        
        Predicate<Animal> predicat = animals -> animals.getColor().equals(color);
        Predicate<Animal> predSpecie = animals -> animals.getSpecies().equals(species);
        Animal leBon = animals.stream().filter(predicat).filter(predSpecie).findFirst().get();
        
        animals.remove(leBon);
     
        return leBon;    
    }

    
    public boolean hasAvailable(){
        return animals.isEmpty();
    }
    
    public long getNbAnimal(Color color, Species species){
        Predicate<Animal> predicat = animals -> animals.getColor().equals(color);
        Predicate<Animal> predSpecie = animals -> animals.getSpecies().equals(species);
        long cpt = animals.stream().filter(predicat).filter(predSpecie).count();
        return cpt;
        
      
    }

    @Override
    public String toString() {
        return "Pieces{" + animals + '}';
    }
     
     
    
    
}
