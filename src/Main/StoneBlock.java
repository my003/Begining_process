/*
    Name: 16 (BOM IT)
    Member names & IU code:
        ITCSIU21204 -  Nguyen Huynh Thao My
        ITCSIU21219 -  Do Dinh Phuc
        ITITWE20021 -  Nguyen Tran Nguyen Anh
        ITCSIU21063 -  Le Thu Hoang
    Purpose: Following the concept of Block class, create the stone block's attributes and features
             import image and set position.
*/
package Main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class StoneBlock extends Block{
    private Image stone;

    public StoneBlock(int x, int y){
        super(x, y);
        stone = new ImageIcon(this.getClass().getResource("Image/block.png")).getImage();
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