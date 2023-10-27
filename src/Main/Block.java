package Main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Block {
    protected int x, y;
    protected Rectangle rectangle;

    protected Block(int x, int y){
        this.x = x;
        this.y = y;
        rectangle = new Rectangle(45 + x*45, 45 + y*45, 45, 45);
    }
    protected void render(Graphics g){};
}
