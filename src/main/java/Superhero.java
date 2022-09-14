import java.util.Arrays;

public class Superhero {
    boolean human;
    private String name;
    private String superheroName = "Unkown";
    private String superPowers;
    private int creationYear, Strength;

    public Superhero(String name, String superheroName, String superPowers, int creationYear, int strength) {
        this.name = name;
        if (superheroName != null)
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

    public String isHuman(){
        if (this.human){
            return "ja";
        }else{
            return "nej";
        }
    }
}
