package Main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Explode4down extends Explosion{
            private Image explode4down;

    public Explode4down(int x, int y){
        super(x, y);
        explode4down = new ImageIcon(this.getClass().getResource("Image/bombbang_down3.png")).getImage();
        rectangle = new Rectangle(x*45+45, y*45+45, 45, 45*4);
    }

    @Override
    protected void render(Graphics g) {
        bangdown3(g);
    }

    public void bangdown3(Graphics g){
        g.drawImage(explode4down, x*45+45, y*45+45, null);
    }

    protected void updatePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
