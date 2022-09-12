import java.util.Arrays;

public class Superhero {
    private String name, superheroName;
    private String superPowers;
    private int creationYear, Strength;

    public Superhero(String name, String superheroName, String superPowers, int creationYear, int strength) {
        this.name = name;
        this.superheroName = superheroName;
        this.superPowers = superPowers;
        this.creationYear = creationYear;
        Strength = strength;
    }
    public String getName() {
        return name;
    }

    public String getSuperheroName() {
        return superheroName;
    }

    public String getSuperPowers() {
        return superPowers;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public int getStrength() {
        return Strength;
    }
}
