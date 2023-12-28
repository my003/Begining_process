package Main;

import entity.Entity;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Explosion extends Entity {
    public Explosion(int x, int y){
        super(x, y);
    }
    public abstract void render(Graphics g);

    protected abstract void updatePosition(int x, int y);

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean isCollide(Rectangle r){
        return rectangle.intersects(r);
    }

    public void setData(Data data){
    }

    public void sensor(Rectangle r, int n){}

}