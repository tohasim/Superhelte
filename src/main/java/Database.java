import java.util.ArrayList;

public class Database {
    ArrayList<Superhero> superheroes = new ArrayList<>();

    public void CreateHero(String name, boolean isHuman, String superheroName, String superPowers, int creationYear, int strength) {
        superheroes.add(new Superhero(name, isHuman, superheroName, superPowers, creationYear, strength));
    }
    public void CreateHero(Superhero heroToAdd) {
        superheroes.add(heroToAdd);
    }


    public ArrayList<Superhero> searchSuperhero(String searchTerm){
        ArrayList<Superhero> matches = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            if (superhero.getSuperheroName().toLowerCase().contains(searchTerm.toLowerCase().trim()) || superhero.getName().toLowerCase().contains(searchTerm.toLowerCase().trim())){
                matches.add(superhero);
            }
        }
        if (matches.isEmpty()){
            return null;
        }
        return matches;
    }
    public void createTestData() {
        CreateHero("Clark Kent", false, "Superman", "Flyve, Røngtensyn, laserøjne", 1963, 9000);
        CreateHero("Bruce Wayne", true, "Batman", "Rig", 1964, 1337);
        CreateHero("Homelander", true, "", "Flyve, Røngtensyn, Laserøjne", 2020, 8999);
        CreateHero("Queen Maeve", true, "", "Superstyke, Plot armor", 2020, 7000);
    }
}
