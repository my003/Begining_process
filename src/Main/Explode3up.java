package Main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Explode3up extends Explosion{
        private Image explode3up;

    public Explode3up(int x, int y){
        super(x, y);
        explode3up = new ImageIcon(this.getClass().getResource("Image/bombbang_up2.png")).getImage();
        rectangle = new Rectangle(x*45+45, y*45+45-45*2, 45, 45*3);
    }

    @Override
    protected void render(Graphics g) {
        bangup2(g);
    }

    public void bangup2(Graphics g){
        g.drawImage(explode3up, x*45+45, y*45+45-45*2, null);
    }

    protected void updatePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
