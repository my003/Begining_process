package Main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class BombItem extends Block{
    private Image bomb;
    private Data data;

    public BombItem(int x, int y){
        super(x, y);
        bomb = new ImageIcon(this.getClass().getResource("Image/item_bomb.gif")).getImage();
        rectangle.setBounds(55+x*45, 55+y*45, 25, 25);
    }

    public void render(Graphics g){
        g.drawImage(bomb, 45+x*45, 45+y*45, null);
    }

    public void setData(Data data){
        this.data = data;
    }

    public boolean isCollide(Rectangle r){
        return rectangle.intersects(r);
    }

    public void sensor(Rectangle r, int n){
        if (isCollide(r)) {
            data.trap("BombItem", n);
            data.detatchItem(this);
        }
    }
}