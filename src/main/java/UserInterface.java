import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    private Database superHeroDataBase;
    private Scanner keyboard;

    public UserInterface() {
        this.superHeroDataBase = new Database();
        this.keyboard = new Scanner(System.in);
    }

    public void StartProgram() {
        CreateTestData();
        MainLoop();
    }

    private void MainLoop() {
        boolean shouldRun = true;
        int menuItem = 0;
        while (shouldRun) {
            System.out.println("Velkommen til superhelte maskinen! \n" +
                    "1: Opret Superhelt\n" +
                    "2: Vis alle superhelte\n" +
                    "3: Søg efter superhelt\n" +
                    "4: Redigér superhelt\n" +
                    "9: Afslut");
            try{
                menuItem = keyboard.nextInt();
            }catch (InputMismatchException IME){
                System.out.println("Ikke korrekt input, vælg en valgmulighed ved at skrive et tal");
            }
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
        boolean heroChosen = false;
        int indexHeroToEdit = 0;
        Superhero heroToEdit = null;
        while(!heroChosen){
            System.out.println("Vælg hvilken superhelt du gerne vil redigere: ");
            superHeroDataBase.PrintHeroes();
            try{
                indexHeroToEdit = keyboard.nextInt();
            }catch (InputMismatchException IME){
                System.out.println("Ikke korrekt input, vælg en superhelt ved at skrive et tal");
            }
            keyboard.nextLine();
            try{
                heroToEdit = superHeroDataBase.Superheroes.get(indexHeroToEdit - 1);
                heroChosen = true;
            } catch (IndexOutOfBoundsException IOBE){
                System.out.printf("Vælg venligst et tal mellem 1 og %d %n", superHeroDataBase.Superheroes.size());
                heroChosen = false;
            }
        }
        System.out.println("Hvad vil du gerne redigere?");
        boolean attributeChosen = false;
        int menuItem = 0;
        while(!attributeChosen){
            System.out.printf("1: Navn \n" +
                    "2: Menneskestatus \n" +
                    "3: Superheltenavn \n" +
                    "4: Superkræfter \n" +
                    "5: Oprindelsesår \n" +
                    "6: Styrke\n");
            try{
                menuItem = keyboard.nextInt();
                attributeChosen = true;
            }
            catch(InputMismatchException IME){
                attributeChosen = false;
                System.out.printf("Ikke korrekt input, vælg en attribut ved at skrive et tal");
            }
            keyboard.nextLine();
        }
        System.out.println("Ok, hvad vil du gerne ændre det til?");
        String change = keyboard.nextLine();
        switch (menuItem) {
            case 1:
                heroToEdit.setName(change);
                break;
            case 2:
                boolean changeSet = false;
                while(!changeSet) {
                    switch (change){
                        case("j"):
                            heroToEdit.setHuman(true);
                            changeSet = true;
                            break;
                        case("n"):
                            heroToEdit.setHuman(false);
                            changeSet = true;
                            break;
                        default:
                            System.out.println("Vælg venligst (j)a eller (n)ej");
                            break;
                    }
                }
                break;
            case 3:
                heroToEdit.setSuperheroName(change);
                break;
            case 4:
                heroToEdit.setSuperPowers(change);
                break;
            case 5:
                boolean intSet = false;
                while(!intSet) {
                    try {
                        heroToEdit.setCreationYear(Integer.parseInt(change));
                        intSet = true;
                    } catch (InputMismatchException IME){
                        System.out.printf("Ikke korrekt input, skriv venligst et tal");
                        intSet = false;
                    }
                }
                break;
            case 6:
                intSet = false;
                while(!intSet) {
                    try {
                        heroToEdit.setCreationYear(Integer.parseInt(change));
                        intSet = true;
                    } catch (InputMismatchException IME){
                        System.out.printf("Ikke korrekt input, skriv venligst et tal");
                        intSet = false;
                    }
                }
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

    private void SuperSearch(Database heroes, Scanner keyboard) {
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

    private void CreateSuperhero(Database heroes, Scanner keyboard) {
        boolean answered = false;
        boolean isHuman = false;
        String superheroName = "";
        String hasSuperName = "";
        String superPowers;
        int Strength = 0;
        String name;
        int creationYear = 0;
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
        boolean intChosen = false;
        while(!intChosen){
            System.out.println("Hvilket år er din superhelt lavet?");
            try{
                creationYear = keyboard.nextInt();
                intChosen = true;
            }
            catch(InputMismatchException IME){
                System.out.println("Ikke korrekt input, skriv venligst et årstal");
                intChosen = false;
            }
            keyboard.nextLine();
        }
        intChosen = false;
        while(!intChosen){
            System.out.println("Hvor stærk er din superhelt?");
            try{
                Strength = keyboard.nextInt();
                intChosen = true;
            }
            catch(InputMismatchException IME){
                System.out.printf("Ikke korrekt input, skriv venligst et årstal");
                intChosen = false;
            }
            keyboard.nextLine();
        }
        heroes.CreateHero(name, isHuman, superheroName, superPowers, creationYear, Strength);
    }
}
