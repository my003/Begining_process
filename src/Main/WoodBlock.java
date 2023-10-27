package Main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class WoodBlock extends Block{
    private Image wood;

    public WoodBlock(int x, int y){
        super(x, y);
        wood = new ImageIcon(this.getClass().getResource("Image/boxgo.png")).getImage();
    }

    public void render(Graphics g){
        g.drawImage(wood, 45+x*45, 45+y*45, null);
    }

    public boolean isCollide(Rectangle r){
        return rectangle.intersects(r);
    }
    
}
