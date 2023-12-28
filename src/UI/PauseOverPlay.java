package UI;

import java.awt.*;
import java.awt.event.MouseEvent;

import GameState.GameStates;
import GameState.Play;

import javax.swing.*;

public class PauseOverPlay {

    private Play play;
    private Image background,screen;
    private int bgX, bgY, bgW, bgH;
    private SoundButton musicButton;
    private EffectButton effectButton;
    private Button menuB, replayB, unpauseB;

    public PauseOverPlay(Play play) {
        this.play = play;
        loadBackground();
        createSoundButtons();
        //createUrmButtons();
        //createVolumeButton();

    }

    private void createSoundButtons() {
        musicButton = new SoundButton(312, 384, 108, 88);
        effectButton = new EffectButton(481, 385, 108, 88);
    }

    private void createUrmButtons() {
//        int menuX = (int) (313 * Game.SCALE);
//        int replayX = (int) (387 * Game.SCALE);
//        int unpauseX = (int) (462 * Game.SCALE);
//        int bY = (int) (325 * Game.SCALE);
//
//        menuB = new UrmButton(menuX, bY, 66, 66, 2);
//        replayB = new UrmButton(replayX, bY, URM_SIZE, URM_SIZE, 1);
//        unpauseB = new UrmButton(unpauseX, bY, URM_SIZE, URM_SIZE, 0);

    }

    private void loadBackground() {
        background = new ImageIcon(this.getClass().getResource("btn/pausebg.png")).getImage();
        screen = new ImageIcon(this.getClass().getResource("btn/subbg.png")).getImage();
        bgW = 947;
        bgH = 675;
        bgX = 0;
        bgY = 0;
    }

    public void update() {
        musicButton.update();
        effectButton.update();
    }

    public void draw(Graphics g) {
        // Background
        g.drawImage(background, bgX, bgY, bgW, bgH, null);
        g.drawImage(screen, 247, 152, 400, 400, null);

        // Sound buttons
        musicButton.draw(g);
        effectButton.draw(g);
    }

    public void mousePressed(MouseEvent e) {
        if (isIn(e, musicButton))
            musicButton.setMousePressed(true);
        else if (isIn(e, effectButton))
            effectButton.setMousePressed(true);
        else if (isIn(e, menuB))
            menuB.setMousePressed(true);
        else if (isIn(e, replayB))
            replayB.setMousePressed(true);
        else if (isIn(e, unpauseB))
            unpauseB.setMousePressed(true);
    }

    public void mouseReleased(MouseEvent e) {
        if (isIn(e, musicButton)) {
            if (musicButton.isMousePressed())
                musicButton.setMuted(!musicButton.isMuted());

        } else if (isIn(e, effectButton)) {
            if (effectButton.isMousePressed())
                effectButton.setMuted(!effectButton.isMuted());
        } else if (isIn(e, menuB)) {
            if (menuB.isMousePressed()) {
                GameStates.state = GameStates.MENU;
                play.unpauseGame();
            }
        } else if (isIn(e, replayB)) {
            if (replayB.isMousePressed())
                System.out.println("Reset!");
        } else if (isIn(e, unpauseB)) {
            if (unpauseB.isMousePressed())
                play.unpauseGame();
        }

        musicButton.resetBools();
        effectButton.resetBools();
        menuB.resetBools();
        replayB.resetBools();
        unpauseB.resetBools();

    }

    public void mouseMoved(MouseEvent e) {
        musicButton.setMouseOver(false);
        effectButton.setMouseOver(false);
        menuB.setMouseOver(false);
        replayB.setMouseOver(false);
        unpauseB.setMouseOver(false);

        if (isIn(e, musicButton))
            musicButton.setMouseOver(true);
        else if (isIn(e, effectButton))
            effectButton.setMouseOver(true);
        else if (isIn(e, menuB))
            menuB.setMouseOver(true);
        else if (isIn(e, replayB))
            replayB.setMouseOver(true);
        else if (isIn(e, unpauseB))
            unpauseB.setMouseOver(true);
    }

    private boolean isIn(MouseEvent e, PauseButton b) {
        return b.getBounds().contains(e.getX(), e.getY());
    }

}