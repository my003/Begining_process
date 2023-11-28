package Main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Explode4left extends Explosion{
        private Image explode4left;

    public Explode4left(int x, int y){
        super(x, y);
        explode4left = new ImageIcon(this.getClass().getResource("Image/bombbang_left3.png")).getImage();
        rectangle = new Rectangle(x*45+45-45*3, y*45+45, 45*4, 45);
    }

    @Override
    protected void render(Graphics g) {
        bangleft3(g);
    }

    public void bangleft3(Graphics g){
        g.drawImage(explode4left, x*45+45-45*3, y*45+45, null);
    }

    protected void updatePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
