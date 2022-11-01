import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
    private Database superHeroDataBase;
    private Scanner keyboard;
    UserInterface ui;

    public Controller() {
        this.superHeroDataBase = new Database();
        this.keyboard = new Scanner(System.in);
        this.ui = new UserInterface();
    }
    public void startProgram() {
        superHeroDataBase.createTestData();
        mainLoop();
    }

    private void mainLoop() {
        boolean shouldRun = true;
        int menuItem = 0;
        while (shouldRun) {
            ui.welcomeMessage();
            try{
                menuItem = keyboard.nextInt();
            }catch (InputMismatchException IME){
                ui.signalMessage(SignalEnum.INCORRECT_INPUT);
            }
            keyboard.nextLine();
            switch (menuItem) {
                case 1:
                    createSuperhero();
                    break;
                case 2:
                    printHeroes();
                    break;
                case 3:
                    superSearch();
                    break;
                case 4:
                    editHero();
                    break;
                case 9:
                    ui.signalMessage(SignalEnum.GOODBYE);
                    shouldRun = false;
                    break;
                default:
                    ui.signalMessage(SignalEnum.NOT_AN_OPTION);
            }
        }
    }
    public void printHeroes() {
        for (Superhero hero : superHeroDataBase.Superheroes) {
            ui.printHero(hero ,superHeroDataBase.Superheroes.indexOf(hero));
        }
    }



    private void editHero() {
        boolean heroChosen = false;
        int indexHeroToEdit = 0;
        Superhero heroToEdit = null;
        while(!heroChosen){
            ui.signalMessage(SignalEnum.CHOOSE_HERO);
            printHeroes();
            try{
                indexHeroToEdit = keyboard.nextInt();
            }catch (InputMismatchException IME){
                ui.signalMessage(SignalEnum.INCORRECT_INPUT);
            }
            keyboard.nextLine();
            try{
                heroToEdit = superHeroDataBase.Superheroes.get(indexHeroToEdit - 1);
                heroChosen = true;
            } catch (IndexOutOfBoundsException IOBE){
                ui.chooseNumberInRange(superHeroDataBase.Superheroes.size());
                heroChosen = false;
            }
        }
        ui.signalMessage(SignalEnum.CHOOSE_EDIT_OPTION);
        boolean attributeChosen = false;
        int menuItem = 0;
        while(!attributeChosen){
            ui.printAttributeList();
            try{
                menuItem = keyboard.nextInt();
                attributeChosen = true;
            }
            catch(InputMismatchException IME){
                attributeChosen = false;
                ui.signalMessage(SignalEnum.INCORRECT_INPUT);
            }
            keyboard.nextLine();
        }
        ui.signalMessage(SignalEnum.ASK_FOR_EDIT);
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
                            ui.signalMessage(SignalEnum.INCORRECT_INPUT_BOOLEAN);
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
                        ui.signalMessage(SignalEnum.INCORRECT_INPUT_INT);
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
                        ui.signalMessage(SignalEnum.INCORRECT_INPUT_INT);
                        intSet = false;
                    }
                }
                break;
            default:
                ui.signalMessage(SignalEnum.INCORRECT_INPUT);
        }
        ui.confirmChange(heroToEdit, superHeroDataBase.Superheroes.indexOf(heroToEdit));
    }
    private void superSearch() {
        ArrayList<Superhero> match;
        ui.signalMessage(SignalEnum.CHOOSE_SEARCH_OPTION);
        String searchTerm = keyboard.nextLine();
        match = superHeroDataBase.searchSuperhero(searchTerm);
        if (match != null){
            if (match.size() == 1){
                ui.signalMessage(SignalEnum.HERO_FOUND);
                ui.printHero(match.get(0), superHeroDataBase.Superheroes.indexOf(match.get(0)));
            }else {
                ui.signalMessage(SignalEnum.HEROES_FOUND);
                for (Superhero superhero : match) {
                    ui.printHero(superhero, superHeroDataBase.Superheroes.indexOf(superhero));
                }
            }
        }else{
            ui.signalMessage(SignalEnum.NO_HEROES_FOUND);
        }
    }
    private void createSuperhero() {
        boolean answered = false;
        boolean isHuman = false;
        String superheroName = "";
        String hasSuperName = "";
        String superPowers;
        int Strength = 0;
        String name;
        int creationYear = 0;
        ui.signalMessage(SignalEnum.ASK_FOR_NAME);
        name = keyboard.nextLine();
        while(!answered){
            ui.signalMessage(SignalEnum.ASK_IF_SUPERHERONAME);
            hasSuperName = keyboard.nextLine();
            if (hasSuperName.equals("j")) {
                ui.signalMessage(SignalEnum.ASK_FOR_SUPERHERONAME);
                superheroName = keyboard.nextLine();
                answered = true;
            } else if (hasSuperName.equals("n")) {
                answered = true;
            } else {
                ui.signalMessage(SignalEnum.INCORRECT_INPUT_BOOLEAN);
            }
        }
        answered = false;
        while(!answered){
            ui.signalMessage(SignalEnum.ASK_IF_HUMAN);
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
                    ui.signalMessage(SignalEnum.INCORRECT_INPUT_BOOLEAN);
            }
        }
        ui.signalMessage(SignalEnum.ASK_FOR_POWERS);
        superPowers = keyboard.nextLine();
        boolean intChosen = false;
        while(!intChosen){
            ui.signalMessage(SignalEnum.ASK_FOR_CREATION_YEAR);
            try{
                creationYear = keyboard.nextInt();
                intChosen = true;
            }
            catch(InputMismatchException IME){
                ui.signalMessage(SignalEnum.INCORRECT_INPUT_YEAR);
                intChosen = false;
            }
            keyboard.nextLine();
        }
        intChosen = false;
        while(!intChosen){
            ui.signalMessage(SignalEnum.ASK_FOR_STRENGTH_LEVEL);
            try{
                Strength = keyboard.nextInt();
                intChosen = true;
            }
            catch(InputMismatchException IME){
                ui.signalMessage(SignalEnum.INCORRECT_INPUT_STRENGTH);
                intChosen = false;
            }
            keyboard.nextLine();
        }
        superHeroDataBase.CreateHero(name, isHuman, superheroName, superPowers, creationYear, Strength);
    }
}
