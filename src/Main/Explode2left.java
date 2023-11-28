package Main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Explode2left extends Explosion{
        private Image explode2left;

    public Explode2left(int x, int y){
        super(x, y);
        explode2left = new ImageIcon(this.getClass().getResource("Image/bombbang_left1.png")).getImage();
        rectangle = new Rectangle(x*45+45-45*1, y*45+45, 45*2, 45);
    }

    @Override
    protected void render(Graphics g) {
        bangleft1(g);
    }

    public void bangleft1(Graphics g){
        g.drawImage(explode2left, x*45+45-45*1, y*45+45, null);
    }

    protected void updatePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
