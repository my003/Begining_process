/*
    Name: 16 (BOM IT)
    Member names & IU code:
        ITCSIU21204 -  Nguyen Huynh Thao My
        ITCSIU21219 -  Do Dinh Phuc
        ITITWE20021 -  Nguyen Tran Nguyen Anh
        ITCSIU21063 -  Le Thu Hoang
    Purpose: According to Block's extension, shoe item disappears
             when the player touches it and increasing item collection ( rise the speed).
*/
package Main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class ShoeItem extends Block{
    private Image shoe;
    private Data data;

    public ShoeItem(int x, int y){
        super(x, y);
        shoe = new ImageIcon(this.getClass().getResource("Image/item_shoe.gif")).getImage();
        rectangle.setBounds(55+x*45, 55+y*45, 25, 25);
    }

    public void render(Graphics g){
        g.drawImage(shoe, 45+x*45, 45+y*45, null);
    }

    public void setData(Data data){
        this.data = data;
    }

    public boolean isCollide(Rectangle r){
        return rectangle.intersects(r);
    }

    public void sensor(Rectangle r, int n){
        if (isCollide(r)) {
            data.trap("ShoeItem", n);
            data.detatchItem(this);
        }
    }
}