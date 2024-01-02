/*
    Name: 16 (BOM IT)
    Member names & IU code:
        ITCSIU21204 -  Nguyen Huynh Thao My
        ITCSIU21219 -  Do Dinh Phuc
        ITITWE20021 -  Nguyen Tran Nguyen Anh
        ITCSIU21063 -  Le Thu Hoang
    Purpose: Checking the collide with the entity around (including bomb and item and box)
             to find place where players can pass.
*/
package Main;

import java.awt.Rectangle;

public class Check {
    public static Rectangle rec1 = new Rectangle(0, 0, 35, 35);
    public static boolean CheckCollide(int x, int y, LoadMap map){
        rec1.setLocation(x+5, y+5);
        if (x<35 || y <35 || x>680 || y>585) return false;
        for (Block block: map.getMap()) if (block.isCollide(rec1)) return false;
        for (Bomb bomb: map.getBombs(1)) if (bomb.isCollide(rec1) && !bomb.getPermitCollide()) return false;
        for (Bomb bomb: map.getBombs(2)) if (bomb.isCollide(rec1) && !bomb.getPermitCollide()) return false;
        return true;
    }
}