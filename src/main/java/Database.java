import java.util.ArrayList;

public class Database {
    ArrayList<Superhero> Superheroes = new ArrayList<>();

    public void CreateHero(String name, boolean isHuman, String superheroName, String superPowers, int creationYear, int strength) {
        Superheroes.add(new Superhero(name, isHuman, superheroName, superPowers, creationYear, strength));
    }

    public void PrintHeroes() {
        for (Superhero superhero : Superheroes) {
            PrintHero(superhero);
        }
    }

    public void PrintHero(Superhero hero){
        System.out.printf("Helt nr %d: \n" +
                        "Navn: %s \n" +
                        "Superheltenavn: %s \n" +
                        "Er menneske: %s \n" +
                        "Superkræfter: %s \n" +
                        "Oprindelsesår: %d \n" +
                        "Styrke: %d\n\n",
                (Superheroes.indexOf(hero) + 1), hero.getName(), hero.getSuperheroName(), hero.isHuman(), hero.getSuperPowers(), hero.getCreationYear(), hero.getStrength());
    }

    public Superhero SearchSuperhero(String searchTerm){
        ArrayList<Superhero> matches = new ArrayList<>(1);
        for (Superhero superhero : Superheroes) {
            if (superhero.getName().toLowerCase().contains(searchTerm.toLowerCase())){
                matches.add(superhero);
            }
        }
        if (matches.isEmpty()){
            return null;
        }
        return matches.get(0);
    }
}
