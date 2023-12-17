package Main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Block extends Entity{

    protected Block(int x, int y){
        super(x, y);
        rectangle = new Rectangle(45 + x*45, 45 + y*45, 45, 45);
    }
    
    protected abstract void render(Graphics g);

    protected abstract boolean isCollide(Rectangle r);

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void sensor(Rectangle r, int n){}

    public void setData(Data data){}
}
