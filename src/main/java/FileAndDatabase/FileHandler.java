package FileAndDatabase;

import MainClasses.Superhero;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    File file;
    PrintStream output;
    Scanner input;

    public FileHandler() {
        file = new File("Resources/Superhelte.txt");
    }

    public void saveHeroes(ArrayList<Superhero> superheroes) throws FileNotFoundException {
        output = new PrintStream(file);
        if (!superheroes.isEmpty()) {
            for (Superhero superhero : superheroes) {
                for (int i = 0; i < superhero.getAttributes().size() - 1; i++) {
                    output.print(superhero.getAttributes().get(i) + "; ");
                }
                output.println(superhero.getAttributes().get(superhero.getAttributes().size() - 1));
            }
        }
    }

    public ArrayList<Superhero> loadHeroes() throws FileNotFoundException {
        ArrayList<Superhero> returnList = new ArrayList<>();
        Superhero superheroToAdd;
        input = new Scanner(file);
        while (input.hasNextLine()){
            String[] attributeList = input.nextLine().split("; ");
            superheroToAdd  = new Superhero(
                    attributeList[0],
                    attributeList[1].equals("true"),
                    attributeList[2],
                    attributeList[3],
                    Integer.parseInt(attributeList[4]) ,
                    Integer.parseInt(attributeList[5]));
            returnList.add(superheroToAdd);
        }
        return returnList;
    }
}
