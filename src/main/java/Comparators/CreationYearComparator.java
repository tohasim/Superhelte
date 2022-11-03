package Comparators;

import MainClasses.Superhero;

import java.util.Comparator;

public class CreationYearComparator implements Comparator<Superhero> {
    @Override
    public int compare(Superhero o1, Superhero o2) {
        return o1.getCreationYear() - o2.getCreationYear();
    }
}
