package Main;

import java.awt.Rectangle;
import java.awt.Graphics;

public abstract class Entity {
    protected int x, y;
    protected Rectangle rectangle;

    protected Entity(int x, int y){
        this.x = x;
        this.y = y;
        rectangle = new Rectangle(x+2, y+2, 41, 41);
    }
    
    protected void render(Graphics g){};


}
