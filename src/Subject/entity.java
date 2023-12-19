package Subject;

import java.awt.*;

public class entity {
    public static final int LEFT = 1;
    public static final int RIGHT = 2;
    public static final int UP = 3;
    public static final int DOWN = 4;
    public static final int ALIVE = 1;
    public static final int DEAD = 0;
    public static final int BOMBER = 1;
    public static final int BOMB = 4;

    protected int x, y, orient;
    protected Rectangle rectangle;


    public void changeDirect(int orient) {
        this.orient = orient;
    }

    public void render(Graphics g){};
    protected entity(int x, int y){
        this.x = x;
        this.y = y;
    }
}
