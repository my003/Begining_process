package Subject;

import Main.Bomb;
import Main.BombAdapter;
import Main.GamePanel;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.awt.Image;
import java.util.Objects;

import javax.swing.ImageIcon;

import static Main.Constant.AnimationConstant.*;

import static Main.Check.CheckCollide;

public class Player1 extends player{
    private Observer observer;
    private int speed = 1;
    private int health;
    private int maxbom = 6;
    private int damage = 3;
    //public static Image[][] animation;


    private int aniTick = 0, aniSpeed = 50, aniIndex =0;
    boolean moving = false;
    private int playerdir = UP;

    private boolean up, right, down, left;

    private ArrayList<Bomb> bombs;
    private final BombAdapter bombAdapter;
    GamePanel gamePanel;

    public Player1(int x, int y, int orient,GamePanel gamePanel){
        super(x,y,orient,gamePanel);
        this.status = entity.ALIVE;
        rectangle = new Rectangle(x+4, y+4, 37, 37);
        this.gamePanel = gamePanel;
        loadAnimation();
        loadbomb(maxbom);
        bombAdapter = new BombAdapter(gamePanel);
    }

    private void loadbomb(int maxbom2) {
        bombs = new ArrayList<>();
        for (int i=0; i<maxbom2; ++i){
            Bomb bomb = new Bomb(-1000, -1000, damage);
            bombs.add(bomb);
        }
    }
    public void setBomb(){
        bombAdapter.addBomb();
    }

    public void loadAnimation() {
//        animation = new Image[4][3];
//        animation[0][0] = new ImageIcon(this.getClass().getResource("Image_Copy/player1_up1.png")).getImage();
//        animation[0][1] = new ImageIcon(this.getClass().getResource("Image_Copy/player1_up1.png")).getImage();
//        animation[0][2] = new ImageIcon(this.getClass().getResource("Image_Copy/player1_up1.png")).getImage();
//        animation[1][0] = new ImageIcon(this.getClass().getResource("Image_Copy/player1_right1.png")).getImage();
//        animation[1][1] = new ImageIcon(this.getClass().getResource("Image_Copy/player1_right2.png")).getImage();
//        animation[1][2] = new ImageIcon(this.getClass().getResource("Image_Copy/player1_right1.png")).getImage();
//        animation[2][0] = new ImageIcon(this.getClass().getResource("Image_Copy/player1_down1.png")).getImage();
//        animation[2][1] = new ImageIcon(this.getClass().getResource("Image_Copy/player1_down1.png")).getImage();
//        animation[2][2] = new ImageIcon(this.getClass().getResource("Image_Copy/player1_down1.png")).getImage();
//        animation[3][0] = new ImageIcon(this.getClass().getResource("Image_Copy/player1_left1.png")).getImage();
//        animation[3][1] = new ImageIcon(this.getClass().getResource("Image_Copy/player1_left2.png")).getImage();
//        animation[3][2] = new ImageIcon(this.getClass().getResource("Image_Copy/player1_left1.png")).getImage();
    }

    public void updatePosition(){
        moving = false;
        if (left && !right && CheckCollide(x-speed, y, gamePanel.getGame().getMap())) {x-= speed; moving = true; playerdir=LEFT;}
        else if (right && !left && CheckCollide(getX()+speed, y, gamePanel.getGame().getMap())) {x+= speed; moving = true; playerdir=RIGHT;}

        if (up && !down && CheckCollide(x, y-speed, gamePanel.getGame().getMap())) {y-= speed; moving = true; playerdir=UP;}
        else if (down && !up && CheckCollide(x, y+speed, gamePanel.getGame().getMap())) {y+= speed; moving = true; playerdir=DOWN;}
        rectangle.setLocation(x, y);
    }


    public void updateAnitick(){
        if (moving){
            aniTick++;
            if (aniTick >= aniSpeed){
                aniTick = 0;
                aniIndex ++;
                if (aniIndex >= 3) aniIndex = 0;
            }}
        else aniIndex = 0;
    }

    public void update(){
        updatePosition();
        updateAnitick();
        bombAdapter.reviseBomb();
    }

    public void setUp(boolean isUp){
        up = isUp;
    }

    public void setRight(boolean isRight){
        right = isRight;
    }

    public void setDown(boolean isDown){
        down = isDown;
    }

    public void setLeft(boolean isLeft){
        left = isLeft;
    }

    public void changeDirect(int orient) {
        super.changeDirect(orient);
        observer = new DrawP1();
        observer.update(this, orient);
    }
//    public void render(Graphics g){
//        loadAnimation();
//        g.drawImage(Player1.animation[playerdir][aniIndex], x+1, y+1, 43, 43, null);
//    }

    public ArrayList<Bomb> getBombs(){
        return bombs;
    }
    public Rectangle getRectangle(){
        return super.rectangle;
    }

    public int getX(){
        return super.getX();
    }
    public int getY(){
        return super.getY();
    }
}