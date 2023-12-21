package Main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class StoneBlock extends Block{
        private Image stone;

    public StoneBlock(int x, int y){
        super(x, y);
        stone = new ImageIcon(this.getClass().getResource("Image/boxsat.png")).getImage();
    }   

    public void render(Graphics g){
        g.drawImage(stone, 45+x*45, 45+y*45, null);
    }

    public boolean isCollide(Rectangle r){
        return rectangle.intersects(r);
    }
    public int getRow(){
        return y;
    }

}
