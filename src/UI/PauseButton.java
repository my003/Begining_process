package UI;

import GameState.GameStates;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PauseButton{
    private int xPos, yPos, rowIndex, index;
    private GameStates state;
    private GameState.Play play;
    private Image imgs[];
    private boolean mouseOver, mousePressed;
    private Rectangle bounds;

    public PauseButton(int xPos, int yPos, int rowIndex, GameStates state) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.rowIndex = rowIndex;
        this.state = state;
        importImage();
        initBounds();
    }

    private void importImage() {
        imgs = new Image[2];
        imgs[0] = new ImageIcon(this.getClass().getResource("btn/pausebtn.png")).getImage();
        imgs[1] = new ImageIcon(this.getClass().getResource("btn/pausebtn(1).png")).getImage();
    }
    private void initBounds() {
        bounds = new Rectangle(xPos, yPos, 180, 39);
    }
    public void draw(Graphics g){
        g.drawImage(imgs[index], xPos, yPos, 180, 39, null);
    }

    public void update() {
        index = 0;
        if (mouseOver)
            index = 1;
        if (mousePressed)
            index = 0;
    }
    public boolean isMouseOver(){
        return mouseOver;
    }
    public void setMouseOver(boolean mouseOver){
        this.mouseOver = mouseOver;
    }
    public boolean isMousePressed() { return mousePressed; }
    public void setMousePressed(boolean mousePressed){
        this.mousePressed = mousePressed;
    }
    public Rectangle getBounds(){
        return bounds;
    }
    public void applyGamestate(){
        GameStates.state = state;
    }
    public void resetBools(){
        mouseOver = false;
        mousePressed = false;
    }

}