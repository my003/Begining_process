package Main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Explode2down extends Explosion{
    private Image explode2down;

    public Explode2down(int x, int y){
        super(x, y);
        explode2down = new ImageIcon(this.getClass().getResource("Image/bombbang_down1.png")).getImage();
        rectangle = new Rectangle(x*45+45, y*45+45, 45, 45*2);
    }

    @Override
    protected void render(Graphics g) {
        bangdown1(g);
    }

    public void bangdown1(Graphics g){
        g.drawImage(explode2down, x*45+45, y*45+45, null);
    }

    @Override
    protected void updatePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
