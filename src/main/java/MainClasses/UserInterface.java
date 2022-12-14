package MainClasses;

import Enums.SignalEnum;
import Enums.SortOptions;
import FileAndDatabase.Database;

import java.util.ArrayList;

public class UserInterface {

    public UserInterface() {
    }

    public void welcomeMessage() {
        System.out.printf("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀               ⣴\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴⢻\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡴⠒⠋⣉⡭⠉⣠⠏\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠖⠋⠉⠉⠉⠉⠒⠒⠚⠉⡠⠴⢚⣩⡤⠖⠋⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠤⠤⠤⠤⠤⠶⠋⡁⠀⠀⠀⠀⡰⠃⠀⢀⣤⠶⠒⠋⠉⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠞⠁⠀⠀⠀⠀⢸⠀⠀⡇⠀⠀⠀⡰⠀⢠⡞⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⢏⠀⠀⠀⣠⣤⣶⣤⣤⣄⠁⠀⠀⢰⠁⣰⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⠤⠤⠶⢞⣁⠀⠓⢀⣤⣿⣿⣿⡿⠛⢿⣆⠀⠀⡆⢰⣻⠖⠋⠉⠙⣓⣺⠗⠒⠒⠲⣄⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⠏⠁⠀⠀⠘⠦⡀⠉⠁⢿⣯⠉⠉⠹⠃⠀⣘⣿⢶⡇⣴⣿⠃⠀⢀⢤⣞⡥⢦⠖⠙⡆⠒⡼⠷⣄\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡼⠃⠙⠂⢤⣤⡀⠀⠈⠢⡀⠘⣿⣆⣀⣀⠤⠒⠛⠙⣧⣿⣿⠁⠀⡰⠁⢸⢫⠆⠘⡆⠀⢳⠀⢸⠀⢽\n" +
                "⠀⠀⠀⠀⠀⠀⠀⣠⡤⣴⣖⠏⠀⠀⢀⣐⣒⣒⡡⠵⣄⠀⠈⣔⣿⣿⠈⠀⠀⠀⠀⠀⠘⣿⡟⣄⠀⢇⠀⣸⣿⠀⠀⢀⠀⡼⠀⢰⠀⡏\n" +
                "⢰⣄⠀⠀⢀⡤⢊⣁⣉⠤⢀⡤⠖⠊⠉⢩⡿⠋⠙⠒⠲⠭⢴⣾⣿⣿⣆⠀⠀⠀⠀⠀⢠⡿⠀⠈⠓⢺⣦⣷⣉⠷⡶⠾⢤⡧⠤⠧⠞⠀\n" +
                "⠀⠙⢯⣉⠉⠈⢉⡩⠔⠊⠁⠀⠀⠀⢠⣏⡤⢤⡐⠒⠢⢤⡀⠈⡟⠻⢝⣲⣄⣀⣠⠴⠋⢀⡠⢦⣤⡼⠁⠀⠹⠦⠧⠼⠶⠃⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠈⠉⠉⠀⠀⠀⠀⠀⠀⢀⡾⠉⠀⢀⣄⣸⡗⠢⣤⡘⣄⡇⠀⠀⠀⠀⢀⣠⠤⢒⣿⡧⠼⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⠀⠀⡴⠺⡀⠀⡇⠀⢻⡧⣏⠀⠀⢰⣾⡟⣀⡴⠞⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣸⠉⡗⠀⢇⠀⠹⡀⢀⣻⣹⡦⠤⠟⠛⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡀⠘⢄⠀⠣⣀⡱⡟⣉⣹⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢦⣀⣱⡶⠚⣷⠖⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ \n");
        System.out.println("Velkommen til superhelte maskinen! \n" +
                "1: Opret Superhelt\n" +
                "2: Vis alle superhelte\n" +
                "3: Søg efter superhelt\n" +
                "4: Redigér superhelt\n" +
                "5: Slet helt\n" +
                "9: Afslut");
    }

    public void signalMessage(SignalEnum signal){
        switch (signal){
            case INCORRECT_INPUT -> System.out.println("Ikke korrekt input, vælg en valgmulighed ved at skrive et tal");
            case INCORRECT_INPUT_YEAR -> System.out.println("Ikke korrekt input, skriv venligst et årstal");
            case INCORRECT_INPUT_STRENGTH -> System.out.printf("Ikke korrekt input, skriv venligst et årstal");
            case GOODBYE -> System.out.println("Ok, hav en god dag");
            case NOT_AN_OPTION -> System.out.println("Ikke en valgmulighed");
            case CHOOSE_HERO -> System.out.println("Vælg hvilken superhelt du gerne vil redigere: ");
            case CHOOSE_EDIT_OPTION -> System.out.println("Hvad vil du gerne redigere?");
            case CHOOSE_SEARCH_OPTION -> System.out.println("Hvad vil du gerne søge efter?");
            case ASK_FOR_EDIT -> System.out.println("Ok, hvad vil du gerne ændre det til?");
            case INCORRECT_INPUT_BOOLEAN -> System.out.println("Vælg venligst (j)a eller (n)ej");
            case INCORRECT_INPUT_INT -> System.out.printf("Ikke korrekt input, skriv venligst et tal");
            case HERO_FOUND -> System.out.println("Jeg fandt denne helt:");
            case HEROES_FOUND -> System.out.println("Jeg fandt følgende helte:");
            case NO_HEROES_FOUND -> System.out.println("Jeg fandt desværre ingen helt med det givne navn");
            case ASK_FOR_NAME -> System.out.println("Hvad hedder din superhelt?");
            case ASK_IF_SUPERHERONAME -> System.out.println("Har din superhelt et superhelte navn? (j/n)");
            case ASK_FOR_SUPERHERONAME -> System.out.println("Hvad er din superhelt's superhelte navn?");
            case ASK_IF_HUMAN -> System.out.println("Er din superhelt menneske? (j/n)");
            case ASK_FOR_POWERS -> System.out.println("Hvilke superkræfter har din superhelt? (f.eks: \"flyve, røngtensyn, superduft\")");
            case ASK_FOR_CREATION_YEAR -> System.out.println("Hvilket år er din superhelt lavet?");
            case ASK_FOR_STRENGTH_LEVEL -> System.out.println("Hvor stærk er din superhelt?");
            case NOT_UNDERSTOOD -> System.out.println("Det forstod jeg ikke");
        }
    }
    public void printHero(Superhero hero, int index){
        System.out.printf("Helt nr %d: \n" +
                        "Navn: %s \n" +
                        "Superheltenavn: %s \n" +
                        "Er menneske: %s \n" +
                        "Superkræfter: %s \n" +
                        "Oprindelsesår: %d \n" +
                        "Styrke: %d\n\n",
                (index + 1), hero.getName(), hero.getSuperheroName(), hero.isHuman(), hero.getSuperPowers(), hero.getCreationYear(), hero.getStrength());
    }

    public void chooseNumberInRange(int upperBound) {
        System.out.printf("Vælg venligst et tal mellem 1 og %d %n", upperBound);
    }

    public void printAttributeList() {
        System.out.printf("1: Navn \n" +
                "2: Menneskestatus \n" +
                "3: Superheltenavn \n" +
                "4: Superkræfter \n" +
                "5: Oprindelsesår \n" +
                "6: Styrke\n");
    }

    public void confirmChange(Superhero heroToEdit, int index) {
        System.out.println("Ok, ændringen er sket, din helt ser nu sådan ud: ");
        printHero(heroToEdit, index);
    }

    public void sortingBy(SortOptions sortingBy) {
        String sortOption;
        switch (sortingBy){
            case CREATION_YEAR -> sortOption = "skabelses år";
            case IS_HUMAN -> sortOption = "om de er menneske";
            case NAME -> sortOption = "navn";
            case STRENGTH -> sortOption = "styrke";
            case SUPERHERO_NAME -> sortOption = "superhelte navn";
            default -> sortOption = "ingenting";
        }
        System.out.println("Helte sorteret efter " + sortOption);
    }

    public void showListMenu(SortOptions sortingBy, ArrayList<Superhero> superheroes) {
        sortingBy(sortingBy);
        printHeroes(superheroes);
        System.out.println("Skriv \"Tilbage\" for at komme tilbage til hovedmenuen, eller sorter listen ved at strive \"Sorter efter {sorteringsparameter}\"\n" +
                "Du kan også give et extra sorterings kriterie ved at skrive \"Sorter efter {sorteringsparameter}, {sorteringsparameter}\"\n " +
                "Sorteringsparametre er: \n" +
                "   \"Skabelses år\"\n" +
                "   \"menneske status\"\n" +
                "   \"navn\"\n" +
                "   \"styrke\"\n" +
                "   \"superhelte navn\"\n");
    }

    public void sortingBy(SortOptions sortingBy, SortOptions sortingBy2) {
        String sortOption;
        String sortOption2;
        switch (sortingBy){
            case CREATION_YEAR -> sortOption = "skabelses år";
            case IS_HUMAN -> sortOption = "om de er menneske";
            case NAME -> sortOption = "navn";
            case STRENGTH -> sortOption = "styrke";
            case SUPERHERO_NAME -> sortOption = "superhelte navn";
            default -> sortOption = "ingenting";
        }
        switch (sortingBy2){
            case CREATION_YEAR -> sortOption2 = "skabelses år";
            case IS_HUMAN -> sortOption2 = "om de er menneske";
            case NAME -> sortOption2 = "navn";
            case STRENGTH -> sortOption2 = "styrke";
            case SUPERHERO_NAME -> sortOption2 = "superhelte navn";
            default -> sortOption2 = "ingenting";
        }
        System.out.println("Helte sorteret efter " + sortOption + " og derefter " + sortOption2);
    }

    public void showListMenu(SortOptions sortingBy, SortOptions sortingBy2, ArrayList<Superhero> superheroes) {
        sortingBy(sortingBy, sortingBy2);
        printHeroes(superheroes);
        System.out.println("Skriv \"Tilbage\" for at komme tilbage til hovedmenuen, eller sorter listen ved at strive \"Sorter efter {sorteringsparameter}\"\n" +
                "Du kan også give et extra sorterings kriterie ved at skrive \"Sorter efter {sorteringsparameter}, {sorteringsparameter}\"\n " +
                "Sorteringsparametre er: \n" +
                "   \"Skabelses år\"\n" +
                "   \"menneske status\"\n" +
                "   \"navn\"\n" +
                "   \"styrke\"\n" +
                "   \"superhelte navn\"\n");
    }

    public void printHeroes(ArrayList<Superhero> superheroes) {
        for (Superhero hero : superheroes) {
            printHero(hero, superheroes.indexOf(hero));
        }
    }
}
