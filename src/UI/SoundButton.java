/*
    Name: 16 (BOM IT)
    Member names & IU code:
        ITCSIU21204 -  Nguyen Huynh Thao My
        ITCSIU21219 -  Do Dinh Phuc
        ITITWE20021 -  Nguyen Tran Nguyen Anh
        ITCSIU21063 -  Le Thu Hoang
    Purpose: Following the concept from the Playbutton, import a picture and set sound button positions on the Play state.
*/
package UI;

import javax.swing.*;
import java.awt.*;

public class SoundButton extends PlayButton{

    private Image[][] imgs;
    private boolean mouseOver, mousePressed;
    private boolean muted;
    private int rowIndex, colIndex;

    public SoundButton(int x, int y, int width, int height) {
        super(x, y, width, height);
        loadSoundImgs();
    }

    private void loadSoundImgs() {
        imgs = new Image[1][2];
        imgs[0][0] = new ImageIcon(this.getClass().getResource("btn/soundbtn.png")).getImage();
        imgs[0][1] = new ImageIcon(this.getClass().getResource("btn/soundbtn(1).png")).getImage();

   }

    public void update() {
        if (muted)
            colIndex = 1;
        else
            colIndex = 0;
        rowIndex = 0;
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