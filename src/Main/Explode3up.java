package Main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Explode3up extends Explosion{
        private Image explode3up;
        private Data data;
        private int damage;

    public Explode3up(int x, int y, int damage){
        super(x, y);
        explode3up = new ImageIcon(this.getClass().getResource("Image/bombbang_up2.png")).getImage();
        rectangle = new Rectangle(x*45+55, y*45+45-45*2, 25, 45*3);
        this.damage = damage;
    }

    @Override
    public void render(Graphics g) {
        bangup2(g);
    }

    public void bangup2(Graphics g){
        g.drawImage(explode3up, x*45+45, y*45+45-45*2, null);
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
        rectangle.setLocation(x*45+55, y*45+45-45*2);
    }
}
