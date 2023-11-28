package Main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Explode3right extends Explosion{
        private Image explode3right;

    public Explode3right(int x, int y){
        super(x, y);
        explode3right = new ImageIcon(this.getClass().getResource("Image/bombbang_right2.png")).getImage();
        rectangle = new Rectangle(x*45+45, y*45+45, 45*3, 45);
    }

    @Override
    protected void render(Graphics g) {
        bangright2(g);
    }

    public void bangright2(Graphics g){
        g.drawImage(explode3right, x*45+45, y*45+45, null);
    }

    protected void updatePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
