package Main;

import java.awt.Rectangle;

public class Check {
    public static Rectangle rec1 = new Rectangle(0, 0, 31, 31);
    public static boolean CheckCollide(int x, int y, LoadMap map){
        rec1.setLocation(x+7, y+7);
        if (x<45 || y <45 || x>675 || y>585) return false;
        for (Block block: map.getMap()) if (block.isCollide(rec1)) return false;
        for (Bomb bomb: map.getBombs(1)) if (bomb.isCollide(rec1) && !bomb.getPermitCollide()) return false; 
        for (Bomb bomb: map.getBombs(2)) if (bomb.isCollide(rec1) && !bomb.getPermitCollide()) return false; 
        return true;
    }

    // public static boolean CheckTrap(int x, int y, LoadMap map){
    //     for (Bomb bomb: map.getBombs(1)) if (bomb.isCollide(rec1) && !bomb.getPermitCollide()) return true;
    //     for (Bomb bomb: map.getBombs(2)) if (bomb.isCollide(rec1) && !bomb.getPermitCollide()) return true;  
    //     return false;
    // }
    


}
