public class Superhero {
    private boolean human;
    private String name;
    private String superheroName = "Unknown";
    private String superPowers;
    private int creationYear, Strength;

    public Superhero(String name, boolean isHuman, String superheroName, String superPowers, int creationYear, int strength) {
        this.name = name;
        this.human = isHuman;
        if (superheroName != "")
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
        Strength = strength;
    }

    public String isHuman(){
        if (this.human){
            return "ja";
        }else{
            return "nej";
        }
    }
}
