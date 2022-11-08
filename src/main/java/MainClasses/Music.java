package MainClasses;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Music {

    public void loadMusic(){
        //make sure file name and location is correct
        File backgroundMusic = new File("Sound\\Justice League.wav");
        playMusic(backgroundMusic);
    }

    static void playMusic(File Sound){
        try{
            Clip music = AudioSystem.getClip();
            music.open(AudioSystem.getAudioInputStream(Sound));
            music.loop(999999);

        }catch (Exception e){
            System.out.println("can not find music file \n" +
                    "go to the MainClasses.Music class and change the file location on line 9");
        }
    }

}
