package Main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Explode4up extends Explosion{
    private Image explode4up;
    private Data data;
    private int damage;

    public Explode4up(int x, int y, int damage){
        super(x, y);
        explode4up = new ImageIcon(this.getClass().getResource("Image/bombbang_up3.png")).getImage();
        rectangle = new Rectangle(x*45+55, y*45+45-45*3, 25, 45*4);
        this.damage = damage;
    }

    @Override
    public void render(Graphics g) {
        bangup3(g);
    }

    public void bangup3(Graphics g){
        g.drawImage(explode4up, x*45+45, y*45+45-45*3, null);
    }

    public void setData(Data data){
        this.data = data;
    }

    public void buffDamage(){
        damage+=1;
    }

    public void sensor(Rectangle r, int n){
        if (isCollide(r)) {data.explode(damage, n);}
    }

    protected void updatePosition(int x, int y) {
        this.x = x;
        this.y = y;
        rectangle.setLocation(x*45+55, y*45+45-45*3);
    }
}