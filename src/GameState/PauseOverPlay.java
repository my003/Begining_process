/*
    Name: 16 (BOM IT)
    Member names & IU code:
        ITCSIU21204 -  Nguyen Huynh Thao My
        ITCSIU21219 -  Do Dinh Phuc
        ITITWE20021 -  Nguyen Tran Nguyen Anh
        ITCSIU21063 -  Le Thu Hoang
    Purpose: Display the Pause state include the rest image and un pause button to comeback the Playing state
*/
package GameState;

import java.awt.*;
import java.awt.event.MouseEvent;
import Main.Game;
import UI.PauseButton;

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
        background = new ImageIcon(this.getClass().getResource("ui/PauseWindow.png")).getImage();
        bgW = 947;
        bgH = 675;
        bgX = 0;
        bgY = 0;
    }

    public void update() {
        pauseButton.update();
    }
    public void draw(Graphics g) {
        // Background
        g.drawImage(background, bgX, bgY, bgW, bgH, null);
        pauseButton.draw(g);

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
        if (isIn(e, pauseButton))
            pauseButton.setMouseOver(true);
    }

    private boolean isIn(MouseEvent e, PauseButton b) {
        return b.getBounds().contains(e.getX(), e.getY());
    }
}