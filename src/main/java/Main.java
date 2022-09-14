import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database superHeroDataBase = new Database();
        Scanner keyboard = new Scanner(System.in);
        boolean shouldRun = true;
        int menuItem;

        superHeroDataBase.CreateHero("Clark Kent", false, "Superman", "Flyve, Røngtensyn, laserøjne", 1963, 9000);
        superHeroDataBase.CreateHero("Bruce Wayne", true, "Batman", "Rig", 1964, 1337);
        superHeroDataBase.CreateHero("Homelander", true, "", "Flyve, Røngtensyn, Laserøjne", 2020, 8999);
        while(shouldRun){
            System.out.println("Velkommen til superhelte maskinen! \n" +
                    "1: Opret Superhelt\n" +
                    "2: Vis alle superhelte\n" +
                    "3: Søg efter superhelt\n" +
                    "9: Afslut");
            menuItem = keyboard.nextInt();
            keyboard.nextLine();
            switch (menuItem){
                case 1:
                    CreateSuperhero(superHeroDataBase, keyboard);
                    break;
                case 2:
                    superHeroDataBase.PrintHeroes();
                    break;
                case 3:
                    SuperSearch(superHeroDataBase, keyboard);
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

    private static void SuperSearch(Database heroes, Scanner keyboard) {
        Superhero match;
        System.out.println("Hvad vil du gerne søge efter?");
        String searchTerm = keyboard.nextLine();
        match = heroes.SearchSuperhero(searchTerm);
        if (match != null){
            System.out.println("Jeg fandt denne helt:");
            heroes.PrintHero(match);
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
