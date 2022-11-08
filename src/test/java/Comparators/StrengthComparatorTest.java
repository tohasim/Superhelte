package Comparators;

import FileAndDatabase.Database;
import MainClasses.Superhero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class StrengthComparatorTest implements Comparator<Superhero> {

    @Override
    public int compare(Superhero o1, Superhero o2) {
        return o1.getStrength() - o2.getStrength();
    }

    @Test
    public void tester() {

        //Arrange
        int ekspectetValue = -333;

        //Act
        Superhero superhero1 = new Superhero("TestNavn1", true, "", "Testkræfter1", 123, 456);
        Superhero superhero2 = new Superhero("TestNavn2", true, "", "Testkræfter2", 456, 789);

        //Assert
        assertEquals(compare(superhero1, superhero2), ekspectetValue);

    }
}