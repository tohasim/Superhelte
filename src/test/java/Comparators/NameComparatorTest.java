package Comparators;

import FileAndDatabase.Database;
import MainClasses.Superhero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class NameComparatorTest {
    Database testDb;
    Database acceptDb;



    @BeforeEach
    void setUp(){
        testDb = new Database();
        acceptDb = new Database();
    }
    @Test
    public void tester(){

        //Arrange
        testDb.createTestData();
        NameComparator NC = new NameComparator();
        Superhero hero1 = new Superhero("Bruce Wayne", true, "Batman", "Rig", 1964, 1337);
        Superhero hero2 = new Superhero("Clark Kent", false, "Superman", "Flyve, Røngtensyn, laserøjne", 1963, 9000);
        Superhero hero3 = new Superhero("Homelander", true, "", "Flyve, Røngtensyn, Laserøjne", 2020, 8999);
        Superhero hero4 = new Superhero("Queen Maeve", true, "", "Superstyke, Plot armor", 2020, 7000);
        acceptDb.createHero(hero1);
        acceptDb.createHero(hero2);
        acceptDb.createHero(hero3);
        acceptDb.createHero(hero4);
        //Act
        testDb.getSuperheroes().sort(NC);

        //Assert
        for (int i = 0; i < testDb.getSuperheroes().size(); i++) {
            assertEquals(testDb.getSuperheroes().get(i).getName(), acceptDb.getSuperheroes().get(i).getName());

        }


    }

}