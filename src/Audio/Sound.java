/*
    Name: 16 (BOM IT)
    Member names & IU code:
        ITCSIU21204 -  Nguyen Huynh Thao My
        ITCSIU21219 -  Do Dinh Phuc
        ITITWE20021 -  Nguyen Tran Nguyen Anh
        ITCSIU21063 -  Le Thu Hoang
    Purpose: Sound and music control (Switch on/off)
*/
package Audio;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

public class Sound {
    AudioInputStream ais;
    Clip clip;
    URL[] soundURL = new URL[7];

    public Sound() {
        soundURL[0] = getResourceURL("src/Audio/sound/music.wav");
        soundURL[1] = getResourceURL("src/Audio/sound/explore.wav");
        soundURL[2] = getResourceURL("src/Audio/sound/lose.wav");
        soundURL[3] = getResourceURL("src/Audio/sound/win.wav");
        soundURL[4] = getResourceURL("src/Audio/sound/pickup.wav");
        soundURL[5] = getResourceURL("src/Audio/sound/select.wav");
        soundURL[6] = getResourceURL("src/Audio/sound/datBom.wav");
    }
    private URL getResourceURL(String resourcePath) {
        try {
            File file = new File(resourcePath);
            URI uri = file.toURI();
            return uri.toURL();
        } catch (IOException e) {
            System.out.println("error get resource : " + e.getMessage());
        }
        return null;
    }

    public void setFile(int i) {
        try {
            ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("error set sound file: " + e.getMessage());
        }
    }

    public void play() {
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }

}