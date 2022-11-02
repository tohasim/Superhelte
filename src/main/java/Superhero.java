import java.util.ArrayList;
import java.util.List;

public class Superhero {
    private Boolean human;
    private String name;
    private String superheroName = "Unknown";
    private String superPowers;
    private Integer creationYear, strength;

    public Superhero(String name, boolean isHuman, String superheroName, String superPowers, int creationYear, int strength) {
        this.name = name;
        this.human = isHuman;
        if (superheroName != "")
            this.superheroName = superheroName;
        this.superPowers = superPowers;
        this.creationYear = creationYear;
        this.strength = strength;
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
        return strength;
    }

    public void setHuman(boolean human) {
        this.human = human;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSuperheroName(String superheroName) {
        this.superheroName = superheroName;
    }

    public void setSuperPowers(String superPowers) {
        this.superPowers = superPowers;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String isHuman(){
        if (this.human){
            return "ja";
        }else{
            return "nej";
        }
    }

    public ArrayList<String> getAttributes(){
        return new ArrayList<>(List.of(
                name,
                superheroName,
                human.toString(),
                superPowers,
                creationYear.toString(),
                strength.toString()));
    }
}
