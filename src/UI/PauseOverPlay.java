package UI;

import java.awt.*;
import java.awt.event.MouseEvent;

import GameState.GameStates;
import GameState.Play;
import Main.Game;

import javax.swing.*;

public class PauseOverPlay {

    private Play play;
    private Image background;
    private int bgX, bgY, bgW, bgH;
    private PauseButton pauseButton;

    public PauseOverPlay(Play play) {
        this.play = play;
        loadBackground();
        createButtons();
    }

    private void createButtons() {
        pauseButton = new PauseButton(740, 438, 0,GameStates.PLAY);
    }
    private void loadBackground() {
        background = new ImageIcon(this.getClass().getResource("btn/PauseWindow.png")).getImage();
        bgW = 947;
        bgH = 675;
        bgX = 0;
        bgY = 0;
    }

    public void update() {
        pauseButton.update();
        //audioOptions.update();

    }
    public void draw(Graphics g) {
        // Background
        g.drawImage(background, bgX, bgY, bgW, bgH, null);
        // Sound buttons
        pauseButton.draw(g);
        //audioOptions.draw(g);

    }
    public void mousePressed(MouseEvent e) {
        if (isIn(e, pauseButton)) {
            pauseButton.setMousePressed(true);
            Game.playSE(5);
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (isIn(e, pauseButton)) {
            if (pauseButton.isMousePressed())
                play.unpauseGame();
        }
        pauseButton.resetBools();
    }

    public void mouseMoved(MouseEvent e) {
        //pauseButton.setMouseOver(false);
        if (isIn(e, pauseButton))
            pauseButton.setMouseOver(true);
    }

    private boolean isIn(MouseEvent e, PauseButton b) {
        return b.getBounds().contains(e.getX(), e.getY());
    }
}