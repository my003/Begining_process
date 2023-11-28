package Main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Explode2up extends Explosion{
    private Image explode2up;

    public Explode2up(int x, int y){
        super(x, y);
        explode2up = new ImageIcon(this.getClass().getResource("Image/bombbang_up1.png")).getImage();
        rectangle = new Rectangle(x*45+45, y*45+45-45*1, 45, 45*2);
    }

    @Override
    protected void render(Graphics g) {
        bangup1(g);
    }

    public void bangup1(Graphics g){
        g.drawImage(explode2up, x*45+45, y*45+45-45*1, null);
    }

    protected void updatePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
