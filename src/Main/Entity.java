package Main;

import java.awt.Rectangle;
import java.awt.Graphics;

public abstract class Entity {
    protected int x, y;
    protected Rectangle rectangle;

    protected Entity(int x, int y){
        this.x = x;
        this.y = y;
    }

    protected void render(Graphics g){};


}