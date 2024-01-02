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

public class Explode4down extends Explosion{
    private Image explode4down;
    private Data data;
    private int damage;

    public Explode4down(int x, int y, int damage){
        super(x, y);
        explode4down = new ImageIcon(this.getClass().getResource("Image/bombbang_down3.png")).getImage();
        rectangle = new Rectangle(x*45+55, y*45+45, 25, 45*4);
        this.damage = damage;
    }

    @Override
    public void render(Graphics g) {
        bangdown3(g);
    }

    public void bangdown3(Graphics g){
        g.drawImage(explode4down, x*45+45, y*45+45, null);
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
        rectangle.setLocation(x*45+55, y*45+45);
    }
}