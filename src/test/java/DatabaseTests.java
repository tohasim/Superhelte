import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTests {

    Database db;

    @BeforeEach
    void setUp() {
        db = new Database();
        db.CreateTestData();
    }

    @Test
    void createHero() {
        //Arrange
        int expectedSize = 5;

        //Act
        db.CreateHero("TestNavn2", true, "", "Testkræfter2", 123, 456);

        //Assert
        assertEquals(expectedSize, db.Superheroes.size());
    }

    @Test
    void createTestData(){
        // Arrange
        int expectedSize = 8;

        //Act
        db.CreateTestData();

        //Assert

        assertEquals(expectedSize, db.Superheroes.size());
    }

    @Test
    void searchSuperheroZeroResults() {
        //Act
        ArrayList<Superhero> resultList = db.SearchSuperhero("IngenHeltMedDetteNavn");
        //Assert
        assertNull(resultList);
    }


    @Test
    void searchSuperheroOneResult() {
        //Arrange
        int expectedSearchSize = 1;
        //Act
        ArrayList<Superhero> resultList = db.SearchSuperhero("Maeve");
        //Assert
        assertEquals(resultList.size(), expectedSearchSize);
    }

    @Test
    void searchSuperheroMultipleResults() {
        //Arrange
        int expectedSearchSize = 2;
        //Act
        ArrayList<Superhero> resultList = db.SearchSuperhero("man");
        //Assert
        assertEquals(resultList.size(), expectedSearchSize);
    }
    @Test
    void searchSuperheroCaseSens() {
        //Arrange
        int expectedSearchSize = 1;
        //Act
        ArrayList<Superhero> resultList = db.SearchSuperhero("suPERMan");
        //Assert
        assertEquals(resultList.size(), expectedSearchSize);
    }
    @Test
    void searchSuperheroWhiteSpace() {
        //Arrange
        int expectedSearchSize = 1;
        //Act
        ArrayList<Superhero> resultList = db.SearchSuperhero("    SuperMan    ");
        //Assert
        assertEquals(resultList.size(), expectedSearchSize);
    }
}