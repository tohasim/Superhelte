package Comparators;

import FileAndDatabase.Database;
import MainClasses.Superhero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanComparatorTest {

    Database db;
    Database db2;

    @BeforeEach
    void setUp() {
        db = new Database();
        db2 = new Database();
    }
    @Test
    void isHuman() {
        //Arrange
        db.createTestData();
        HumanComparator HumanComparator = new HumanComparator();
        //Act
        int expected = 0;
        int actual = HumanComparator.compare(db.getSuperheroes().get(0),db.getSuperheroes().get(1));
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    void notHuman() {
        //Arrange
        db.createTestData();
        HumanComparator HumanComparator = new HumanComparator();
        //Act
        int expected = -4;
        int actual = HumanComparator.compare(db.getSuperheroes().get(0),db.getSuperheroes().get(3));
        //Assert
        assertEquals(expected,actual);
    }

    @Test
    void testSortTestData(){
        //Arrange
        db.createTestData();
        HumanComparator HumanComparator = new HumanComparator();
        Superhero superhero1 = new Superhero("Bruce Wayne", true, "Batman", "Rig", 1964, 1337);
        Superhero superhero2 = new Superhero("Homelander", true, "", "Flyve, Røngtensyn, Laserøjne", 2020, 8999);
        Superhero superhero3 = new Superhero("Queen Maeve", true, "", "Superstyke, Plot armor", 2020, 7000);
        Superhero superhero4 = new Superhero("Clark Kent", false, "Superman", "Flyve, Røngtensyn, laserøjne", 1963, 9000);
        db2.createHero(superhero1);
        db2.createHero(superhero2);
        db2.createHero(superhero3);
        db2.createHero(superhero4);
        //Act
        db.getSuperheroes().sort(HumanComparator);
        //Assert
        for (int i = 0; i < db.getSuperheroes().size(); i++) {
            assertEquals(db.getSuperheroes().get(i).isHuman(), db2.getSuperheroes().get(i).isHuman());
        }
    }
}