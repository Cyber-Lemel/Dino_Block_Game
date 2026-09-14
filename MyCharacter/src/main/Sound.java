package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    Clip clip;
    URL soundURL[] = new URL[30];

    public Sound(){

        soundURL[0] = getClass().getResource("/sound/BGDino.wav");
        soundURL[1] = getClass().getResource("/sound/NewSpeed.wav");   
        soundURL[2] = getClass().getResource("/sound/CollectEgg.wav");
        soundURL[3] = getClass().getResource("/sound/Gameover.wav");
        soundURL[4] = getClass().getResource("/sound/TimerEnd.wav");
        soundURL[5] = getClass().getResource("/sound/GameFinished.wav");
        soundURL[6] = getClass().getResource("/sound/hitMonsters.wav");
        soundURL[7] = getClass().getResource("/sound/receiveDamage.wav");
        soundURL[8] = getClass().getResource("/sound/swingSword.wav");
        soundURL[9] = getClass().getResource("/sound/TittleMusic.wav");


    }

    public void setFile(int i){
        try {
            
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL [i]);
            clip = AudioSystem.getClip();
            clip.open(ais);


        } catch (Exception e) {
           
        }
    } 

    public void play(){

        clip.start();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

   public void stop() {
        if(clip != null && clip.isRunning()){
        clip.stop();
        }
    }

}
