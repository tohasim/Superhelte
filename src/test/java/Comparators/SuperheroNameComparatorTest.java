package Comparators;

import FileAndDatabase.Database;
import MainClasses.Superhero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.management.StringValueExp;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SuperheroNameComparatorTest {

    Database db;
    Database db2;

    @BeforeEach
    void setUp() {
        db = new Database();
        db2 = new Database();
    }
    @Test
    void compare() {
        //Arrange
        db.createTestData();
        SuperheroNameComparator nameComparator = new SuperheroNameComparator();
        //Act
        int expected = 0;
        int actual = nameComparator.compare(db.getSuperheroes().get(0),db.getSuperheroes().get(1));
        //Assert
        assertEquals(expected,actual);
    }

    @Test
    void testSortTestData(){
        //Arrange
        db.createTestData();
        SuperheroNameComparator nameComparator = new SuperheroNameComparator();
        Superhero superhero1 = new Superhero("Bruce Wayne", true, "Batman", "Rig", 1964, 1337);
        Superhero superhero2 = new Superhero("Clark Kent", false, "Superman", "Flyve, Røngtensyn, laserøjne", 1963, 9000);
        Superhero superhero3 = new Superhero("Homelander", true, "", "Flyve, Røngtensyn, Laserøjne", 2020, 8999);
        Superhero superhero4 = new Superhero("Queen Maeve", true, "", "Superstyke, Plot armor", 2020, 7000);
        db2.createHero(superhero1);
        db2.createHero(superhero2);
        db2.createHero(superhero3);
        db2.createHero(superhero4);
        //Act
        db.getSuperheroes().sort(nameComparator);
        //Assert
        for (int i = 0; i < db.getSuperheroes().size(); i++) {
            assertEquals(db.getSuperheroes().get(i).getSuperheroName(), db2.getSuperheroes().get(i).getSuperheroName());
        }
    }
}