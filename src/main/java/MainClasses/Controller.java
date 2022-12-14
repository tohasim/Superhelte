package MainClasses;

import Comparators.*;
import Enums.SignalEnum;
import Enums.SortOptions;
import FileAndDatabase.Database;
import FileAndDatabase.FileHandler;

import java.io.FileNotFoundException;
import java.util.*;

public class Controller {
    private Database superHeroDataBase;
    private Scanner keyboard;
    private boolean unsavedChanges = false;
    UserInterface ui;
    FileHandler fileHandler;
    CreationYearComparator yearComparator;
    HumanComparator humanComparator;
    NameComparator nameComparator;
    StrengthComparator strengthComparator;
    SuperheroNameComparator superheroNameComparator;
    SortOptions sortingBy;
    SortOptions sortingBy2;

    public Controller() throws FileNotFoundException {
        this.superHeroDataBase = new Database();
        this.keyboard = new Scanner(System.in);
        this.ui = new UserInterface();
        fileHandler = new FileHandler();
        sortingBy = SortOptions.NAME;
    }

    public void startProgram() throws FileNotFoundException {
        yearComparator = new CreationYearComparator();
        humanComparator = new HumanComparator();
        nameComparator = new NameComparator();
        strengthComparator = new StrengthComparator();
        superheroNameComparator = new SuperheroNameComparator();

        createLoadedHeroes();
        if (superHeroDataBase.getSuperheroes().isEmpty())
            superHeroDataBase.createTestData();
        mainLoop();
    }

    public ArrayList<Superhero> heroesSortedBy(SortOptions sortingBy) {
        ArrayList<Superhero> returnList = superHeroDataBase.getSuperheroes();
        switch (sortingBy) {
            case CREATION_YEAR:
                returnList.sort(yearComparator);
                break;
            case IS_HUMAN:
                returnList.sort(humanComparator);
                break;
            case NAME:
                returnList.sort(nameComparator);
                break;
            case STRENGTH:
                returnList.sort(strengthComparator);
                break;
            case SUPERHERO_NAME:
                returnList.sort(superheroNameComparator);
                break;
        }
        return returnList;
    }
    public ArrayList<Superhero> heroesSortedBy(SortOptions sortingBy, SortOptions sortingBy2) {
        ArrayList<Superhero> returnList = superHeroDataBase.getSuperheroes();
        Comparator primaryComparator = null;
        Comparator secondaryComparator = null;
        primaryComparator = switch (sortingBy) {
            case CREATION_YEAR -> yearComparator;
            case IS_HUMAN -> humanComparator;
            case NAME -> nameComparator;
            case STRENGTH -> strengthComparator;
            case SUPERHERO_NAME -> superheroNameComparator;
        };
        secondaryComparator = switch (sortingBy2) {
            case CREATION_YEAR -> yearComparator;
            case IS_HUMAN -> humanComparator;
            case NAME -> nameComparator;
            case STRENGTH -> strengthComparator;
            case SUPERHERO_NAME -> superheroNameComparator;
        };

        returnList.sort(primaryComparator.thenComparing(secondaryComparator));
        return returnList;
    }



    private void createLoadedHeroes() throws FileNotFoundException {
        for (Superhero superhero : fileHandler.loadHeroes()) {
            superHeroDataBase.createHero(superhero);
        }
    }

    private void mainLoop() throws FileNotFoundException {
        Music music = new Music();
        music.loadMusic();

        boolean shouldRun = true;
        int menuItem = 0;
        while (shouldRun) {
            ui.welcomeMessage();
            try {
                menuItem = keyboard.nextInt();
            } catch (InputMismatchException IME) {
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
                case 5:
                    deleteHero();
                    break;
                case 9:
                    ui.signalMessage(SignalEnum.GOODBYE);
                    if (unsavedChanges) {
                        fileHandler.saveHeroes(superHeroDataBase.getSuperheroes());
                    }
                    shouldRun = false;
                    break;
                default:
                    ui.signalMessage(SignalEnum.NOT_AN_OPTION);
            }
        }
    }

    private void deleteHero() {
        Superhero heroToDelete = chooseHero();
        superHeroDataBase.deleteHero(heroToDelete);
        unsavedChanges = true;
    }

    private Superhero chooseHero() {
        boolean heroChosen = false;
        int indexHeroToEdit = 0;
        Superhero heroToDelete = null;
        while (!heroChosen) {
            ui.signalMessage(SignalEnum.CHOOSE_HERO);
            ui.printHeroes(superHeroDataBase.getSuperheroes());
            try {
                indexHeroToEdit = keyboard.nextInt();
            } catch (InputMismatchException IME) {
                ui.signalMessage(SignalEnum.INCORRECT_INPUT);
            }
            keyboard.nextLine();
            try {
                heroToDelete = superHeroDataBase.getSuperheroes().get(indexHeroToEdit - 1);
                heroChosen = true;
            } catch (IndexOutOfBoundsException IOBE) {
                ui.chooseNumberInRange(superHeroDataBase.getSuperheroes().size());
                heroChosen = false;
            }
        }
        return heroToDelete;
    }

    public void printHeroes() {
        boolean inMenu = true;
        while (inMenu) {
            if (sortingBy2 == null){
                ArrayList<Superhero> sortedHeroes = heroesSortedBy(sortingBy);
                ui.showListMenu(sortingBy, sortedHeroes);
            }
            else {
                ArrayList<Superhero> sortedHeroes = heroesSortedBy(sortingBy, sortingBy2);
                ui.showListMenu(sortingBy, sortingBy2, sortedHeroes);
            }
            String[] userChoice = keyboard.nextLine().split(",");
            if (userChoice.length == 1) {
                sortingBy2 = null;
                String[] input = userChoice[0].split(" ");
                switch (input[0].toLowerCase()) {
                    case "sorter" -> {
                        switch (String.join(" ", userChoice).toLowerCase()) {
                            case "sorter efter skabelses ??r" -> sortingBy = SortOptions.CREATION_YEAR;
                            case "sorter efter menneske status" -> sortingBy = SortOptions.IS_HUMAN;
                            case "sorter efter navn" -> sortingBy = SortOptions.NAME;
                            case "sorter efter styrke" -> sortingBy = SortOptions.STRENGTH;
                            case "sorter efter superhelte navn" -> sortingBy = SortOptions.SUPERHERO_NAME;
                            default -> ui.signalMessage(SignalEnum.NOT_UNDERSTOOD);
                        }
                    }
                    case "tilbage" -> inMenu = false;
                    default -> ui.signalMessage(SignalEnum.NOT_UNDERSTOOD);
                }
            } else if (userChoice.length == 2) {

                switch (userChoice[0].toLowerCase()) {
                    case "sorter efter skabelses ??r" -> {sortingBy = SortOptions.CREATION_YEAR;}
                    case "sorter efter menneske status" -> {sortingBy = SortOptions.IS_HUMAN;}
                    case "sorter efter navn" -> {sortingBy = SortOptions.NAME;}
                    case "sorter efter styrke" -> {sortingBy = SortOptions.STRENGTH;}
                    case "sorter efter superhelte navn" -> {sortingBy = SortOptions.SUPERHERO_NAME;}
                    case "tilbage" -> inMenu = false;
                    default -> ui.signalMessage(SignalEnum.NOT_UNDERSTOOD);
                }

                switch (userChoice[1].toLowerCase()) {

                    case " skabelses ??r" -> {sortingBy2 = SortOptions.CREATION_YEAR;}
                    case " menneske status" -> {sortingBy2 = SortOptions.IS_HUMAN;}
                    case " navn" -> {sortingBy2 = SortOptions.NAME;}
                    case " styrke" -> {sortingBy2 = SortOptions.STRENGTH;}
                    case " superhelte navn" -> {sortingBy2 = SortOptions.SUPERHERO_NAME;}
                    case "tilbage" -> inMenu = false;
                    default -> ui.signalMessage(SignalEnum.NOT_UNDERSTOOD);
                }
            } else {
                ui.signalMessage(SignalEnum.INCORRECT_INPUT);
            }
        }
    }

    private void editHero() {
        Superhero heroToEdit = chooseHero();
        ui.signalMessage(SignalEnum.CHOOSE_EDIT_OPTION);
        boolean attributeChosen = false;
        int menuItem = 0;
        while (!attributeChosen) {
            ui.printAttributeList();
            try {
                menuItem = keyboard.nextInt();
                attributeChosen = true;
            } catch (InputMismatchException IME) {
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
                while (!changeSet) {
                    switch (change) {
                        case ("j"):
                            heroToEdit.setHuman(true);
                            changeSet = true;
                            break;
                        case ("n"):
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
                while (!intSet) {
                    try {
                        heroToEdit.setCreationYear(Integer.parseInt(change));
                        intSet = true;
                    } catch (InputMismatchException IME) {
                        ui.signalMessage(SignalEnum.INCORRECT_INPUT_INT);
                        intSet = false;
                    }
                }
                break;
            case 6:
                intSet = false;
                while (!intSet) {
                    try {
                        heroToEdit.setStrength(Integer.parseInt(change));
                        intSet = true;
                    } catch (InputMismatchException IME) {
                        ui.signalMessage(SignalEnum.INCORRECT_INPUT_INT);
                        intSet = false;
                    }
                }
                break;
            default:
                ui.signalMessage(SignalEnum.INCORRECT_INPUT);
        }
        ui.confirmChange(heroToEdit, superHeroDataBase.getSuperheroes().indexOf(heroToEdit));
        unsavedChanges = true;
    }

    private void superSearch() {
        ArrayList<Superhero> match;
        ui.signalMessage(SignalEnum.CHOOSE_SEARCH_OPTION);
        String searchTerm = keyboard.nextLine();
        match = superHeroDataBase.searchSuperhero(searchTerm);
        if (match != null) {
            if (match.size() == 1) {
                ui.signalMessage(SignalEnum.HERO_FOUND);
                ui.printHero(match.get(0), superHeroDataBase.getSuperheroes().indexOf(match.get(0)));
            } else {
                ui.signalMessage(SignalEnum.HEROES_FOUND);
                for (Superhero superhero : match) {
                    ui.printHero(superhero, superHeroDataBase.getSuperheroes().indexOf(superhero));
                }
            }
        } else {
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
        while (!answered) {
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
        while (!answered) {
            ui.signalMessage(SignalEnum.ASK_IF_HUMAN);
            switch (keyboard.nextLine()) {
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
        while (!intChosen) {
            ui.signalMessage(SignalEnum.ASK_FOR_CREATION_YEAR);
            try {
                creationYear = keyboard.nextInt();
                intChosen = true;
            } catch (InputMismatchException IME) {
                ui.signalMessage(SignalEnum.INCORRECT_INPUT_YEAR);
                intChosen = false;
            }
            keyboard.nextLine();
        }
        intChosen = false;
        while (!intChosen) {
            ui.signalMessage(SignalEnum.ASK_FOR_STRENGTH_LEVEL);
            try {
                Strength = keyboard.nextInt();
                intChosen = true;
            } catch (InputMismatchException IME) {
                ui.signalMessage(SignalEnum.INCORRECT_INPUT_STRENGTH);
                intChosen = false;
            }
            keyboard.nextLine();
        }
        superHeroDataBase.createHero(name, isHuman, superheroName, superPowers, creationYear, Strength);
        unsavedChanges = true;
    }
}
