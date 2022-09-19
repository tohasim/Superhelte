import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Database superHeroDataBase;
    private Scanner keyboard;

    public UserInterface() {
        this.superHeroDataBase = new Database();
        this.keyboard = new Scanner(System.in);
    }

    public void StartProgram() {
        boolean shouldRun = true;
        int menuItem;
        CreateTestData();

        while (shouldRun) {
            System.out.println("Velkommen til superhelte maskinen! \n" +
                    "1: Opret Superhelt\n" +
                    "2: Vis alle superhelte\n" +
                    "3: Søg efter superhelt\n" +
                    "4: Redigér superhelt\n" +
                    "9: Afslut");
            menuItem = keyboard.nextInt();
            keyboard.nextLine();
            switch (menuItem) {
                case 1:
                    CreateSuperhero(superHeroDataBase, keyboard);
                    break;
                case 2:
                    superHeroDataBase.PrintHeroes();
                    break;
                case 3:
                    SuperSearch(superHeroDataBase, keyboard);
                    break;
                case 4:
                    EditHero();
                    break;
                case 9:
                    System.out.println("Ok, hav en god dag");
                    shouldRun = false;
                    break;
                default:
                    System.out.println("Ikke en valgmulighed");
            }
        }
    }

    private void EditHero() {
        System.out.println("Vælg hvilken superhelt du gerne vil redigere: ");
        superHeroDataBase.PrintHeroes();
        int indexHeroToEdit = keyboard.nextInt();
        Superhero heroToEdit = superHeroDataBase.Superheroes.get(indexHeroToEdit - 1);
        System.out.println("Hvad vil du gerne redigere?");
        System.out.printf("1: Navn \n" +
                "2: Menneskestatus \n" +
                "3: Superheltenavn \n" +
                "4: Superkræfter \n" +
                "5: Oprindelsesår \n" +
                "6: Styrke\n");
        int menuItem = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("Ok, hvad vil du gerne ændre det til?");
        String change = keyboard.nextLine();
        switch (menuItem) {
            case 1:
                heroToEdit.setName(change);
                break;
            case 2:
                if (change.equals("j"))
                    heroToEdit.setHuman(true);
                else if (change.equals("n")) {
                    heroToEdit.setHuman(false);
                }
                break;
            case 3:
                heroToEdit.setSuperheroName(change);
                break;
            case 4:
                heroToEdit.setSuperPowers(change);
                break;
            case 5:
                heroToEdit.setCreationYear(Integer.parseInt(change));
                break;
            case 6:
                heroToEdit.setStrength(Integer.parseInt(change));
                break;
            default:
                System.out.println("Ikke en mulighed");
        }
        System.out.println("Ok, ændringen er sket, din helt ser nu sådan ud: ");
        superHeroDataBase.PrintHero(heroToEdit);
    }

    private void CreateTestData() {
        superHeroDataBase.CreateHero("Clark Kent", false, "Superman", "Flyve, Røngtensyn, laserøjne", 1963, 9000);
        superHeroDataBase.CreateHero("Bruce Wayne", true, "Batman", "Rig", 1964, 1337);
        superHeroDataBase.CreateHero("Homelander", true, "", "Flyve, Røngtensyn, Laserøjne", 2020, 8999);
        superHeroDataBase.CreateHero("Queen Maeve", true, "", "Superstyke, Plot armor", 2020, 7000);
    }

    private static void SuperSearch(Database heroes, Scanner keyboard) {
        ArrayList<Superhero> match;
        System.out.println("Hvad vil du gerne søge efter?");
        String searchTerm = keyboard.nextLine();
        match = heroes.SearchSuperhero(searchTerm);
        if (match != null){
            if (match.size() == 1){
                System.out.println("Jeg fandt denne helt:");
                heroes.PrintHero(match.get(0));
            }else {
                System.out.println("Jeg fandt følgende helte:");
                for (Superhero superhero : match) {
                    heroes.PrintHero(superhero);
                }
            }
        }else{
            System.out.println("Jeg fandt desværre ingen helt med det givne navn");
        }
    }

    private static void CreateSuperhero(Database heroes, Scanner keyboard) {
        boolean answered = false;
        boolean isHuman = false;
        String superheroName = null;
        String hasSuperName = "";
        String superPowers;
        int Strength;
        String name;
        int creationYear;
        System.out.println("Hvad hedder din superhelt?");
        name = keyboard.nextLine();
        while(!answered){
            System.out.println("Har din superhelt et superhelte navn? (j/n)");
            hasSuperName = keyboard.nextLine();
            if (hasSuperName.equals("j")) {
                System.out.println("Hvad er din superhelt's superhelte navn?");
                superheroName = keyboard.nextLine();
                answered = true;
            } else if (hasSuperName.equals("n")) {
                answered = true;
            } else {
                System.out.println("Vælg venligst enten (j)a eller (n)ej");
            }
        }
        answered = false;
        while(!answered){
            System.out.println("Er din superhelt menneske? (j/n)");
            switch (keyboard.nextLine()){
                case "j":
                    isHuman = true;
                    answered = true;
                    break;
                case "n":
                    isHuman = false;
                    answered = true;
                    break;
                default:
                    System.out.println("Vælg venligst enten (j)a eller (n)ej");
            }
        }
        System.out.println("Hvilke superkræfter har din superhelt? (f.eks: \"flyve, røngtensyn, superduft\")");
        superPowers = keyboard.nextLine();
        System.out.println("Hvilket år er din superhelt lavet?");
        creationYear = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("Hvor stærk er din superhelt?");
        Strength = keyboard.nextInt();
        keyboard.nextLine();
        heroes.CreateHero(name, isHuman, superheroName, superPowers, creationYear, Strength);
    }
}
