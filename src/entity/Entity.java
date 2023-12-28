package entity;

import java.awt.Rectangle;
import java.awt.Graphics;

public abstract class Entity {
    public int x, y;
    public Rectangle rectangle;

    protected Entity(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void render(Graphics g){};


}