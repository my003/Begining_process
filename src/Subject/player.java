package Subject;

import Main.GamePanel;

import java.awt.*;

public abstract class player extends entity{
    protected int speed = 1;
    //protected Rectangle rectangle;
    public static int ALLOW_RUN = 0;
    public static int DISALLOW_RUN = 1;
    GamePanel gamePanel;

    protected int sizeBomb, quantityBomb, status, score, heart;
    public player(int x, int y, int speed, GamePanel gamePanel){
        super(x,y);
        //rectangle = new Rectangle(x+4, y+4, 37, 37);
        this.speed = speed;
        this.orient = orient;
        this.gamePanel = gamePanel;
    }
    public void setChange(int orient) {
        super.changeDirect(orient);
    }

    public int getStatus() {
        return status;
    }
    public void loadAnimation() {
    }
    public void updatePosition(){
    }
    public void setScore(int score) {
        this.score = score;
    }
//    public void setChange(int orient) {
//        super.changeOrient(orient);
//    }
    public void render(Graphics g){};

    public int getX(){
        return super.x;
    }
    public int getY(){
        return super.y;
    }
}
