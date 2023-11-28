package Main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Explode2right extends Explosion{
    private Image explode2right;

    public Explode2right(int x, int y){
        super(x, y);
        explode2right = new ImageIcon(this.getClass().getResource("Image/bombbang_right1.png")).getImage();
        rectangle = new Rectangle(x*45+45, y*45+45, 45*2, 45);
    }

    @Override
    protected void render(Graphics g) {
        bangright1(g);
    }

    public void bangright1(Graphics g){
        g.drawImage(explode2right, x*45+45, y*45+45, null);
    }
    protected void updatePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
