package Main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Explode3left extends Explosion{
    private Image explode3left;

    public Explode3left(int x, int y){
        super(x, y);
        explode3left = new ImageIcon(this.getClass().getResource("Image/bombbang_left2.png")).getImage();
        rectangle = new Rectangle(x*45+45-45*2, y*45+45, 45*3, 45);
    }

    @Override
    protected void render(Graphics g) {
        bangleft2(g);
    }

    public void bangleft2(Graphics g){
        g.drawImage(explode3left, x*45+45-45*2, y*45+45, null);
    }

    protected void updatePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
