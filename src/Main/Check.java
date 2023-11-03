package Main;

import java.awt.Rectangle;

public class Check {
    public static boolean CheckCollide(int x, int y, LoadMap map){
        Rectangle rec1 = new Rectangle(x+5, y+5, 35, 35);
        if (x<45 || y <45 || x>675 || y>585) return false;
        for (Block block: map.getMap()) if (block.isCollide(rec1)) return false;
        return true;
    }   
}
