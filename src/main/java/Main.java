import MainClasses.Controller;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Music music = new Music();
        music.loadMusic();
        Controller program = new Controller();
        program.startProgram();
    }
}
