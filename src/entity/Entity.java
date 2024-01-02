/*
    Name: 16 (BOM IT)
    Member names & IU code:
        ITCSIU21204 -  Nguyen Huynh Thao My
        ITCSIU21219 -  Do Dinh Phuc
        ITITWE20021 -  Nguyen Tran Nguyen Anh
        ITCSIU21063 -  Le Thu Hoang
    Purpose: Other classes inherit common characteristics of the entity class
*/
package entity;

import java.awt.Rectangle;
import java.awt.Graphics;

public abstract class Entity {
    public int x, y;
    public Rectangle rectangle;

    protected Entity(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void render(Graphics g){};


}