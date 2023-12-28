package UI;
import GameState.GameStates;
import GameState.Play;
import Main.Game;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.*;
import java.awt.Image;
import static Utilz.Constants.UI.Buttons.*;

public class PauseButton {
    private int xPos, yPos, rowIndex, index;
    private int xOffsetCenter = B_WIDTH / 2;
    private GameStates state;
    private GameState.Play play;

    protected int x, y, width, height;
    protected Rectangle bounds;
    public PauseButton(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        initBounds();
    }
    private void initBounds() {
        bounds = new Rectangle(x, y, width, height);
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }
}
