package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Button extends PauseButton {
    private Image[] imgs;
    private int rowIndex, index;
    private boolean mouseOver, mousePressed;

    public Button (int x, int y, int width, int height, int rowIndex) {
        super(x, y, width, height);
        this.rowIndex = rowIndex;
        loadImgs();
    }

    private void loadImgs() {
        imgs = new Image[3];
        imgs[0] = new ImageIcon(this.getClass().getResource("btn/home.png")).getImage();
        imgs[1] = new ImageIcon(this.getClass().getResource("btn/Reset.png")).getImage();
        imgs[2] = new ImageIcon(this.getClass().getResource("btn/pause.png")).getImage();
    }

    public void update() {
        index = 0;
        if (mouseOver)
            index = 1;
        if (mousePressed)
            index = 0;
    }

    public void draw(Graphics g) {
        g.drawImage(imgs[index], x, y, 66, 66, null);
    }

    public void resetBools() {
        mouseOver = false;
        mousePressed = false;
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

}