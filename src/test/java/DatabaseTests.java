import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTests {

    Database db;

    @BeforeEach
    void setUp() {
        db = new Database();
    }

    @Test
    void createHero() {
        //Arrange
        String expectedName = "TestNavn";
        String expectedHumanStatus = "ja";
        String expectedHeroName = "Unknown";
        String expectedSuperPower = "Testkræfter";
        int expectedCreationYear = 123;
        int expectedStrength = 456;

        //Act
        db.CreateHero("TestNavn", true, "", "Testkræfter", 123, 456);

        //Assert
        assertSame(db.Superheroes.get(0).getName(), expectedName);
        assertSame(db.Superheroes.get(0).isHuman(), expectedHumanStatus);
        assertSame(db.Superheroes.get(0).getSuperheroName(), expectedHeroName);
        assertSame(db.Superheroes.get(0).getSuperPowers(), expectedSuperPower);
        assertEquals(db.Superheroes.get(0).getCreationYear(), expectedCreationYear);
        assertEquals(db.Superheroes.get(0).getStrength(), expectedStrength);
        assertEquals(1, db.Superheroes.size());
    }

    @Test
    void searchSuperhero() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    void editHero() {
        //Arrange
        //Act
        //Assert
    }
}