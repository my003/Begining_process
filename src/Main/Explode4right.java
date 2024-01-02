/*
    Name: 16 (BOM IT)
    Member names & IU code:
        ITCSIU21204 -  Nguyen Huynh Thao My
        ITCSIU21219 -  Do Dinh Phuc
        ITITWE20021 -  Nguyen Tran Nguyen Anh
        ITCSIU21063 -  Le Thu Hoang
    Purpose: Insert the range of explosion.
*/
package Main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Explode4right extends Explosion{
    private Image explode4right;
    private Data data;
    private int damage;

    public Explode4right(int x, int y, int damage){
        super(x, y);
        explode4right = new ImageIcon(this.getClass().getResource("Image/bombbang_right3.png")).getImage();
        rectangle = new Rectangle(x*45+45, y*45+55, 45*4, 25);
        this.damage = damage;
    }

    @Override
    public void render(Graphics g) {
        bangright3(g);
    }

    public void bangright3(Graphics g){
        g.drawImage(explode4right, x*45+45, y*45+45, null);
    }

    public void setData(Data data){
        this.data = data;
    }

    public void buffDamage(){
        damage+=1;
    }

    public void sensor(Rectangle r, int n){
        if (isCollide(r)) {data.explode(damage, n);}
    }

    protected void updatePosition(int x, int y) {
        this.x = x;
        this.y = y;
        rectangle.setLocation(x*45+45, y*45+55);
    }
}