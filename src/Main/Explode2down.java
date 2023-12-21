package Main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Explode2down extends Explosion{
    private Image explode2down;
    private Data data;
    private int damage;

    public Explode2down(int x, int y, int damage){
        super(x, y);
        explode2down = new ImageIcon(this.getClass().getResource("Image/bombbang_down1.png")).getImage();
        rectangle = new Rectangle(x*45+55, y*45+45, 25, 45*2);
        this.damage = damage;
    }

    @Override
    public void render(Graphics g) {
        bangdown1(g);
    }

    public void bangdown1(Graphics g){
        g.drawImage(explode2down, x*45+45, y*45+45, null);
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

    @Override
    protected void updatePosition(int x, int y) {
        this.x = x;
        this.y = y;
        rectangle.setLocation(x*45+55, y*45+45);
    }
}
