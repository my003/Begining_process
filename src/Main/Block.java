package Main;

import entity.Entity;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Block extends Entity {

    protected Block(int x, int y){
        super(x, y);
        rectangle = new Rectangle(50 + x*45, 50 + y*45, 35, 35);
    }

    public abstract void render(Graphics g);

    protected abstract boolean isCollide(Rectangle r);

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void sensor(Rectangle r, int n){}

    public void setData(Data data){}

    public int getRow(){return y;}

    public void setLocation(int x, int y){}
}