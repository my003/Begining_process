package UI;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import GameState.Play;

import javax.swing.*;

public class PauseOverPlay {

    private Play play;
    private Image background;
    private int bgX, bgY, bgW, bgH;
    private SoundButton musicButton, sfxButton;
    private EffectButton effectButton, sfButton;
//    private UrmButton menuB, replayB, unpauseB;
//    private VolumeButton volumeButton;

    public PauseOverPlay(Play play) {
        this.play = play;
        loadBackground();
        createSoundButtons();
        //createUrmButtons();
        //createVolumeButton();

    }

    private void createSoundButtons() {
        int soundX = (int) (450 );
        int musicY = (int) (140);
        int sfxY = (int) (186);
        musicButton = new SoundButton(soundX, musicY, 155, 155);
        sfxButton = new SoundButton(soundX, sfxY, 155, 155);

    }

    private void loadBackground() {
        background = new ImageIcon(this.getClass().getResource("btn/pausebg.png")).getImage();
        bgW = 947;
        bgH = 675;
        bgX = 0;
        bgY = 0;
    }

    public void update() {

        musicButton.update();
        sfxButton.update();

    }

    public void draw(Graphics g) {
        // Background
        g.drawImage(background, bgX, bgY, bgW, bgH, null);

        // Sound buttons
        musicButton.draw(g);
        sfxButton.draw(g);
    }

    public void mouseDragged(MouseEvent e) {
//        if (volumeButton.isMousePressed()) {
//            volumeButton.changeX(e.getX());
//        }

    }

    public void mousePressed(MouseEvent e) {
        if (isIn(e, musicButton))
            musicButton.setMousePressed(true);
        else if (isIn(e, sfxButton))
            sfxButton.setMousePressed(true);
    }

    public void mouseReleased(MouseEvent e) {
        if (isIn(e, musicButton)) {
            if (musicButton.isMousePressed())
                musicButton.setMuted(!musicButton.isMuted());

        } else if (isIn(e, sfxButton)) {
            if (sfxButton.isMousePressed())
                sfxButton.setMuted(!sfxButton.isMuted());
        }

        musicButton.resetBools();
        sfxButton.resetBools();


    }

    public void mouseMoved(MouseEvent e) {
        musicButton.setMouseOver(false);
        sfxButton.setMouseOver(false);

        if (isIn(e, musicButton))
            musicButton.setMouseOver(true);
        else if (isIn(e, sfxButton))
            sfxButton.setMouseOver(true);

    }

    private boolean isIn(MouseEvent e, PauseButton b) {
        return b.getBounds().contains(e.getX(), e.getY());
    }

}