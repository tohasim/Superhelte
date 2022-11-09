import FileAndDatabase.Database;
import MainClasses.Superhero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTests {

    Database db;

    @BeforeEach
    void setUp() {
        db = new Database();
        db.createTestData();
    }

    @Test
    void createHero() {
        //Arrange
        int expectedSize = 5;

        //Act
        db.createHero("TestNavn2", true, "", "Testkræfter2", 123, 456);

        //Assert
        assertEquals(expectedSize, db.getSuperheroes().size());
    }

    @Test
    void createTestData(){
        // Arrange
        int expectedSize = 8;

        //Act
        db.createTestData();

        //Assert

        assertEquals(expectedSize, db.getSuperheroes().size());
    }

    @Test
    void searchSuperheroZeroResults() {
        //Act
        ArrayList<Superhero> resultList = db.searchSuperhero("IngenHeltMedDetteNavn");
        //Assert
        assertNull(resultList);
    }


    @Test
    void searchSuperheroOneResult() {
        //Arrange
        int expectedSearchSize = 1;
        //Act
        ArrayList<Superhero> resultList = db.searchSuperhero("Maeve");
        //Assert
        assertEquals(resultList.size(), expectedSearchSize);
    }

    @Test
    void searchSuperheroMultipleResults() {
        //Arrange
        int expectedSearchSize = 2;
        //Act
        ArrayList<Superhero> resultList = db.searchSuperhero("man");
        //Assert
        assertEquals(resultList.size(), expectedSearchSize);
    }
    @Test
    void searchSuperheroCaseSens() {
        //Arrange
        int expectedSearchSize = 1;
        //Act
        ArrayList<Superhero> resultList = db.searchSuperhero("suPERMan");
        //Assert
        assertEquals(resultList.size(), expectedSearchSize);
    }
    @Test
    void searchSuperheroWhiteSpace() {
        //Arrange
        int expectedSearchSize = 1;
        //Act
        ArrayList<Superhero> resultList = db.searchSuperhero("    SuperMan    ");
        //Assert
        assertEquals(resultList.size(), expectedSearchSize);
    }
}