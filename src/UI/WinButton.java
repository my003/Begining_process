/*
    Name: 16 (BOM IT)
    Member names & IU code:
        ITCSIU21204 -  Nguyen Huynh Thao My
        ITCSIU21219 -  Do Dinh Phuc
        ITITWE20021 -  Nguyen Tran Nguyen Anh
        ITCSIU21063 -  Le Thu Hoang
    Purpose: Import a picture and set the button positions on the Win state.
*/
package UI;

import GameState.GameStates;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.*;
import java.awt.Image;

public class WinButton {
    private int xPos, yPos, rowIndex, index;
    private GameStates state;
    private Image imgs[];
    private boolean mouseOver, mousePressed;
    private Rectangle bounds;
    public WinButton(int xPos, int yPos, int rowIndex, GameStates state){
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
        imgs = new Image[4];
        imgs[0] = new ImageIcon(this.getClass().getResource("btn/homeWinnerbtn.png")).getImage();
        imgs[1] = new ImageIcon(this.getClass().getResource("btn/homeWinnerbtn.png")).getImage();
        imgs[2] = new ImageIcon(this.getClass().getResource("btn/exit_win.png")).getImage();
        imgs[3] = new ImageIcon(this.getClass().getResource("btn/exit_win(1).png")).getImage();

    }
    public void draw(Graphics g){
        g.drawImage(imgs[index], xPos, yPos, 122, 50, null);
    }
    public void update() {
        if (xPos == 324 && yPos == 458 )
            index = 0;
        if (xPos == 494 && yPos == 458 )
            index = 2;
        if (index == 0) {
            if (isMouseOver())
                index = 1;
            if (isMousePressed())
                index = 0;
        }
        if (index == 2) {
            if (isMouseOver())
                index = 3;
            if (isMousePressed())
                index = 2;
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
