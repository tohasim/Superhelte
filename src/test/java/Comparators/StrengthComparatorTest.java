package Comparators;

import FileAndDatabase.Database;
import MainClasses.Superhero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StrengthComparatorTest{

    Database DB;
    Database testDB;


    @BeforeEach
    void setUp(){
        DB = new Database();
        testDB = new Database();
    }

    @Test
    public void tester() {


        //Arrange
        testDB.createTestData();
        StrengthComparator SC = new StrengthComparator();

        Superhero hero1 = new Superhero("Bruce Wayne", true, "Batman", "Rig", 1964, 1337);
        Superhero hero2 = new Superhero("Clark Kent", false, "Superman", "Flyve, Røngtensyn, laserøjne", 1963, 9000);
        Superhero hero3 = new Superhero("Homelander", true, "", "Flyve, Røngtensyn, Laserøjne", 2020, 8999);
        Superhero hero4 = new Superhero("Queen Maeve", true, "", "Superstyke, Plot armor", 2020, 7000);

        DB.createHero(hero1);
        DB.createHero(hero4);
        DB.createHero(hero3);
        DB.createHero(hero2);

        //Act
        testDB.getSuperheroes().sort(SC);
        //Assert
        for (int i = 0; i < testDB.getSuperheroes().size(); i++) {
            assertEquals(testDB.getSuperheroes().get(i).getName(), DB.getSuperheroes().get(i).getName());

        }

    }
}