package Main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class IceTrap extends Block{
    private Image ice;
    private Data data;

    public IceTrap(int x, int y){
        super(x, y);
        ice = new ImageIcon(this.getClass().getResource("Image/ice.png")).getImage();
    }

    public void render(Graphics g){
        g.drawImage(ice, 45+x*45, 45+y*45, null);
    }

    public void setData(Data data){
        this.data = data;
    }

    public boolean isCollide(Rectangle r){
        return rectangle.intersects(r);
    }

    public void sensor(Rectangle r, int n){
        if (isCollide(r)) {data.trap("Ice", n);}
    }
}
