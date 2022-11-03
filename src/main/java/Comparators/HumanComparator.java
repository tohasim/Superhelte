package Comparators;

import FileAndDatabase.Database;
import MainClasses.Superhero;

import java.util.Comparator;

public class HumanComparator implements Comparator<Superhero> {

    @Override
    public int compare(Superhero o1, Superhero o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
