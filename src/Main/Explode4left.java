package Main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Explode4left extends Explosion{
        private Image explode4left;
        private Data data;
    private int damage;

    public Explode4left(int x, int y, int damage){
        super(x, y);
        explode4left = new ImageIcon(this.getClass().getResource("Image/bombbang_left3.png")).getImage();
        rectangle = new Rectangle(x*45+45-45*3, y*45+55, 45*4, 25);
        this.damage = damage;
    }

    @Override
    public void render(Graphics g) {
        bangleft3(g);
    }

    public void bangleft3(Graphics g){
        g.drawImage(explode4left, x*45+45-45*3, y*45+45, null);
    }

    public void setData(Data data){
        this.data = data;
    }

    public void buffDamage(){
        damage+=50;
    }

    public void sensor(Rectangle r, int n){
        if (isCollide(r)) {data.explode(damage, n);}
    }

    protected void updatePosition(int x, int y) {
        this.x = x;
        this.y = y;
        rectangle.setLocation(x*45+45-45*3, y*45+55);
    }
}
