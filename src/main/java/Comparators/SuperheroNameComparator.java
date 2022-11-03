package Comparators;

import MainClasses.Superhero;

import java.util.Comparator;

public class SuperheroNameComparator implements Comparator<Superhero> {
    @Override
    public int compare(Superhero o1, Superhero o2){
        return o1.getSuperheroName().compareTo(o2.getSuperheroName());
    }
}
