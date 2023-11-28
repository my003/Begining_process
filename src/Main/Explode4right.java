package Main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Explode4right extends Explosion{
    private Image explode4right;

    public Explode4right(int x, int y){
        super(x, y);
        explode4right = new ImageIcon(this.getClass().getResource("Image/bombbang_right3.png")).getImage();
        rectangle = new Rectangle(x*45+45, y*45+45, 45*4, 45);
    }

    @Override
    protected void render(Graphics g) {
        bangright3(g);
    }

    public void bangright3(Graphics g){
        g.drawImage(explode4right, x*45+45, y*45+45, null);
    }

    protected void updatePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
