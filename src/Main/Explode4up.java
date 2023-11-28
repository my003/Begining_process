package Main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Explode4up extends Explosion{
    private Image explode4up;

    public Explode4up(int x, int y){
        super(x, y);
        explode4up = new ImageIcon(this.getClass().getResource("Image/bombbang_up3.png")).getImage();
        rectangle = new Rectangle(x*45+45, y*45+45-45*3, 45, 45*4);
    }

    @Override
    protected void render(Graphics g) {
        bangup3(g);
    }

    public void bangup3(Graphics g){
        g.drawImage(explode4up, x*45+45, y*45+45-45*3, null);
    }

    protected void updatePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
