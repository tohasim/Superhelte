import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database heroes = new Database();
        Scanner keyboard = new Scanner(System.in);
        boolean shouldRun = true;
        int menuItem;

        while(shouldRun){
            System.out.println("Velkommen til superhelte maskinen! \n" +
                    "1: Opret Superhelt\n" +
                    "2: Vis alle superhelte\n" +
                    "9: Afslut");
            menuItem = keyboard.nextInt();
            keyboard.nextLine();
            switch (menuItem){
                case 1:
                    CreateSuperhero(heroes, keyboard);
                    break;
                case 2:
                    heroes.PrintHeroes();
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

    private static void CreateSuperhero(Database heroes, Scanner keyboard) {
        if (heroes.isFull()){
            System.out.println("Database full");
            return;
        }
        String superheroName = null;
        String hasSuperName;
        String superPowers;
        int Strength;
        String name;
        int creationYear;
        System.out.println("Hvad hedder din superhelt?");
        name = keyboard.nextLine();
        System.out.println("Har din superhelt et superhelte navn? (j/n)");
        hasSuperName = keyboard.nextLine();
        if (hasSuperName.equals("j")){
            System.out.println("Hvad er  din superhelt's superheltenavn?");
            superheroName = keyboard.nextLine();
        }
        System.out.println("Hvilke superkræfter har din superhelt? (f.eks: \"flyve, røngtensyn, superduft\")");
        superPowers = keyboard.nextLine();
        System.out.println("Hvilket år er din superhelt lavet?");
        creationYear = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("Hvor stærk er din superhelt?");
        Strength = keyboard.nextInt();
        keyboard.nextLine();


        heroes.CreateHero(name, superheroName, superPowers, creationYear, Strength);
    }
}
