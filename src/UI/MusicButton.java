package UI;

import javax.swing.*;
import java.awt.*;

public class MusicButton extends PauseButton {

    private Image[][] imgs;
    private boolean mouseOver, mousePressed;
    private boolean muted;
    private int rowIndex, colIndex;

    public MusicButton(int x, int y, int width, int height) {
        super(x, y, width, height);
        loadSoundImgs();
    }

    private void loadSoundImgs() {
        imgs = new Image[2][2];
        imgs[0][0] = new ImageIcon(this.getClass().getResource("btn/sound_Music_on.png")).getImage();
        imgs[0][1] = new ImageIcon(this.getClass().getResource("btn/sound_Music_on.png")).getImage();
        imgs[1][0] = new ImageIcon(this.getClass().getResource("btn/sound_Music_off.png")).getImage();
        imgs[1][1] = new ImageIcon(this.getClass().getResource("btn/sound_Music_off.png")).getImage();
    }

    public void update() {
        if (muted)
            rowIndex = 1;
        else
            rowIndex = 0;

        colIndex = 0;
        if (mouseOver)
            colIndex = 1;
        if (mousePressed)
            colIndex = 0;

    }

    public void resetBools() {
        mouseOver = false;
        mousePressed = false;
    }

    public void draw(Graphics g) {
        g.drawImage(imgs[rowIndex][colIndex], x, y, width, height, null);
    }

    public boolean isMouseOver() {
        return mouseOver;
    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    public boolean isMousePressed() {
        return mousePressed;
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }

    public boolean isMuted() {
        return muted;
    }

    public void setMuted(boolean muted) {
        this.muted = muted;
    }

}