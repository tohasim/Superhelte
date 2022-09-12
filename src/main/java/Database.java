public class Database {
    Superhero[] Superheroes = new Superhero[5];

    public void CreateHero(String name, String superheroName, String superPowers, int creationYear, int strength) {
        for (int i = 0; i < Superheroes.length; i++) {
            if (Superheroes[i] == null){
                Superheroes[i] = new Superhero(name, superheroName, superPowers, creationYear, strength);
                break;
            }
        }
    }

    public void PrintHeroes() {
        for (int i = 0; i < Superheroes.length; i++) {
            Superhero hero = Superheroes[i];
            if (Superheroes[i] != null){
                System.out.printf("Helt nr %d: \n" +
                                "Navn: %s \n" +
                                "Superheltenavn: %s \n" +
                                "Superkræfter: %s \n" +
                                "Oprindelsesår: %d \n" +
                                "Styrke: %d\n\n",
                        (i + 1), hero.getName(), hero.getSuperheroName(), hero.getSuperPowers(), hero.getCreationYear(), hero.getStrength());
            }
        }
    }
}
