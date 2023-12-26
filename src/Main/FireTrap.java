package Main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class FireTrap extends Block{
    private Image fire;
    private Data data;

    public FireTrap(int x, int y){
        super(x, y);
        fire = new ImageIcon(this.getClass().getResource("Image/fire.gif")).getImage();
        rectangle.setBounds(55+x*45, 55+y*45, 25, 25);
    }

    public void render(Graphics g){
        g.drawImage(fire, 45+x*45, 45+y*45, null);
    }

    public void setData(Data data){
        this.data = data;
    }

    public boolean isCollide(Rectangle r){
        return rectangle.intersects(r);
    }

    public void sensor(Rectangle r, int n){
        if (isCollide(r)) {data.trap("Fire", n);}
    }
}