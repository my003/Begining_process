package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Buttons extends PlayButton {
    private Image[] imgs;
    private int index;
    private boolean mouseOver, mousePressed;

    public Buttons(int x, int y, int width, int height) {
        super(x, y, width, height);
        loadImgs();
    }

    private void loadImgs() {
        imgs = new Image[4];
        imgs[0] = new ImageIcon(this.getClass().getResource("btn/pausebtn.png")).getImage();
        imgs[1] = new ImageIcon(this.getClass().getResource("btn/pausebtn(1).png")).getImage();
        imgs[2] = new ImageIcon(this.getClass().getResource("btn/exitbtn.png")).getImage();
        imgs[3] = new ImageIcon(this.getClass().getResource("btn/exitbtn(1).png")).getImage();
    }

    public void update() {
        if (x == 740 && y == 438 )
            index = 0;
        if (x == 740 && y == 594 )
            index = 2;
        if (index == 0) {
            if (mouseOver)
                index = 1;
            if (mousePressed)
                index = 0;
        }
        if (index == 2) {
            if (mouseOver)
                index = 3;
            if (mousePressed)
                index = 2;
        }

    }
    public void draw(Graphics g) {
        g.drawImage(imgs[index], x, y, 187, 39, null);
    }

    public void resetBools() {
        mouseOver = false;
        mousePressed = false;
    }

    public boolean isMouseOver() { return mouseOver; }

    public void setMouseOver(boolean mouseOver) { this.mouseOver = mouseOver; }

    public boolean isMousePressed() { return mousePressed; }

    public void setMousePressed(boolean mousePressed) { this.mousePressed = mousePressed;}
}