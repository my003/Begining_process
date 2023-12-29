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
    private SoundButton soundButton;
    private Button menuB, replayB, unpauseB;

    public PauseOverPlay(Play play) {
        this.play = play;
        //loadBackground();
        createButtons();
    }
    private void createButtons() {
        soundButton = new SoundButton(740, 489, 190, 115);
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
        soundButton.update();
    }

    public void draw(Graphics g) {
        // Background
        g.drawImage(background, bgX, bgY, bgW, bgH, null);
        g.drawImage(screen, 247, 152, 400, 400, null);

        // Sound buttons
        soundButton.draw(g);
    }

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseMoved(MouseEvent e) {}

    private boolean isIn(MouseEvent e, PauseButton b) {
        return b.getBounds().contains(e.getX(), e.getY());
    }

}