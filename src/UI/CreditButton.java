package UI;
import GameState.GameStates;
import GameState.Play;
import Main.Game;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.*;
import java.awt.Image;
import static Utilz.Constants.UI.Buttons.*;

public class CreditButton {
    private int xPos, yPos, rowIndex, index;
    private GameStates state;
    private Image imgs[];
    private boolean mouseOver, mousePressed;
    private Rectangle bounds;
    public CreditButton(int xPos, int yPos, int rowIndex, GameStates state){
        this.xPos =xPos;
        this.yPos = yPos;
        this.rowIndex = rowIndex;
        this.state = state;
        importImage();
        initBounds();
    }
    private void initBounds() {
        bounds = new Rectangle(xPos, yPos, 122, 50);
    }
    private void importImage() {
        imgs = new Image[2];
        imgs[0] = new ImageIcon(this.getClass().getResource("btn/exitbtn.png")).getImage();
        imgs[1] = new ImageIcon(this.getClass().getResource("btn/exitbtn(1).png")).getImage();

    }
    public void draw(Graphics g){
        g.drawImage(imgs[index], xPos, yPos, 122, 50, null);
    }
    public void update() {
        index = 0;
        if (isMouseOver())
            index = 1;
        if (isMousePressed())
            index = 0;
    }
    public boolean isMouseOver(){
        return mouseOver;
    }
    public void setMouseOver(boolean mouseOver){
        this.mouseOver = mouseOver;
    }
    public boolean isMousePressed(){
        return mousePressed;
    }
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
