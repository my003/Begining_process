package UI;
import GameState.GameStates;
import GameState.Play;
import Main.Game;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.*;
import java.awt.Image;
import static Utilz.Constants.UI.Buttons.*;

public class PlayButton {
    private int xPos, yPos, rowIndex, index;
    private int xOffsetCenter = B_WIDTH / 2;
    private GameStates state;
    private GameState.Play play;

    private Image imgs[];
    private boolean mouseOver, mousePressed;
    private Rectangle bounds;
    public PlayButton(int xPos, int yPos, int rowIndex, GameStates state){
        this.xPos =xPos;
        this.yPos = yPos;
        this.rowIndex = rowIndex;
        this.state = state;
        importImage();
        initBounds();
    }
    private void initBounds() {
        bounds = new Rectangle(xPos, yPos, 180, 39);
    }
    private void importImage() {
        imgs = new Image[8];
        imgs[0] = new ImageIcon(this.getClass().getResource("btn/pausebtn.png")).getImage();
        imgs[1] = new ImageIcon(this.getClass().getResource("btn/pausebtn(1).png")).getImage();
        imgs[2] = new ImageIcon(this.getClass().getResource("btn/soundbtn.png")).getImage();
        imgs[3] = new ImageIcon(this.getClass().getResource("btn/soundbtn(1).png")).getImage();
        imgs[4] = new ImageIcon(this.getClass().getResource("btn/musicbtn.png")).getImage();
        imgs[5] = new ImageIcon(this.getClass().getResource("btn/musicbtn(1).png")).getImage();
        imgs[6] = new ImageIcon(this.getClass().getResource("btn/exitbtn.png")).getImage();
        imgs[7] = new ImageIcon(this.getClass().getResource("btn/exitbtn(1).png")).getImage();
    }
    public void draw(Graphics g){
        g.drawImage(imgs[index], xPos, yPos, 187, 39, null);
    }
    public void update() {
        if (xPos == 740 && yPos == 438 )
            index = 0;
        if (xPos == 740 && yPos == 489 )
            index = 2;
        if (xPos == 740 && yPos == 540 )
            index = 4;
        if (xPos == 740 && yPos == 594 )
            index = 6;
        if (index == 0) {
            if (isMouseOver())
                index = 0;
            if (isMousePressed())
                index = 1;
        }
        if (index == 2) {
            if (isMouseOver())
                index = 2;
            if (isMousePressed())
                index = 3;
        }
        if (index == 4) {
            if (isMouseOver())
                index = 4;
            if (isMousePressed())
                index = 5;
        }
        if (index == 6) {
            if (isMouseOver())
                index = 7;
            if (isMousePressed())
                index = 6;
        }
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

