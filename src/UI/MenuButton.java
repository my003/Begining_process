/*
    Name: 16 (BOM IT)
    Member names & IU code:
        ITCSIU21204 -  Nguyen Huynh Thao My
        ITCSIU21219 -  Do Dinh Phuc
        ITITWE20021 -  Nguyen Tran Nguyen Anh
        ITCSIU21063 -  Le Thu Hoang
    Purpose: Import a picture and set the button positions on the Menu state.
*/
package UI;
import GameState.GameStates;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.*;
import java.awt.Image;

public class MenuButton {
    private int xPos, yPos, rowIndex, index;
    private GameStates state;
    private Image imgs[];
    private boolean mouseOver, mousePressed;
    private Rectangle bounds;
    public MenuButton(int xPos, int yPos, int rowIndex, GameStates state){
        this.xPos =xPos;
        this.yPos = yPos;
        this.rowIndex = rowIndex;
        this.state = state;
        importImage();
        initBounds();
    }
    private void initBounds() {
        bounds = new Rectangle(xPos, yPos, 180, 67);
    }
    private void importImage() {
        imgs = new Image[6];
        imgs[0] = new ImageIcon(this.getClass().getResource("btn/btnstart.png")).getImage();
        imgs[1] = new ImageIcon(this.getClass().getResource("btn/btnstart(1).png")).getImage();
        imgs[2] = new ImageIcon(this.getClass().getResource("btn/btncredit.png")).getImage();
        imgs[3] = new ImageIcon(this.getClass().getResource("btn/btncredit(1).png")).getImage();
        imgs[4] = new ImageIcon(this.getClass().getResource("btn/btnexit.png")).getImage();
        imgs[5] = new ImageIcon(this.getClass().getResource("btn/btnexit(1).png")).getImage();

    }
    public void draw(Graphics g){
        g.drawImage(imgs[index], xPos, yPos, 180, 67, null);
    }
    public void update() {
        if (xPos == 384 && yPos == 337 )
            index = 0;
        if (xPos == 384 && yPos == 445 )
            index = 2;
        if (xPos == 384 && yPos == 553 )
            index = 4;
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
        if (index == 4) {
            if (isMouseOver())
                index = 5;
            if (isMousePressed())
                index = 4;
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
        System.out.println(state);
    }
    public void resetBools(){
        mouseOver = false;
        mousePressed = false;
    }
}
