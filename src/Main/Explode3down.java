package Main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Explode3down extends Explosion{
        private Image explode3down;

    public Explode3down(int x, int y){
        super(x, y);
        explode3down = new ImageIcon(this.getClass().getResource("Image/bombbang_down2.png")).getImage();
        rectangle = new Rectangle(x*45+45, y*45+45, 45, 45*3);
    }

    @Override
    protected void render(Graphics g) {
        bangdown2(g);
    }

    public void bangdown2(Graphics g){
        g.drawImage(explode3down, x*45+45, y*45+45, null);
    }

    protected void updatePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
