package Main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import static Main.Constant.AnimationConstant.*;

import static Main.Check.CheckCollide;

public class Player extends Entity{

    private int speed = 3;
    private int health;
    private int maxbom;
    private int damage;

    private int aniTick = 0, aniSpeed = 50, aniIndex =0;
    boolean moving = false;
    private int playerdir = UP;

    private boolean up, right, down, left;

    private Image animation[][];

    GamePanel gamePanel;

    public Player(int x, int y, GamePanel gamePanel){
        super(x,y);
        this.gamePanel = gamePanel;
        loadAnimation();
    }

    private void loadAnimation() {
        animation = new Image[4][3];
        animation[0][0] = new ImageIcon(this.getClass().getResource("Image/up1.png")).getImage();
        animation[0][1] = new ImageIcon(this.getClass().getResource("Image/up2.png")).getImage();
        animation[0][2] = new ImageIcon(this.getClass().getResource("Image/up3.png")).getImage();
        animation[1][0] = new ImageIcon(this.getClass().getResource("Image/right1.png")).getImage();
        animation[1][1] = new ImageIcon(this.getClass().getResource("Image/right2.png")).getImage();
        animation[1][2] = new ImageIcon(this.getClass().getResource("Image/right3.png")).getImage();
        animation[2][0] = new ImageIcon(this.getClass().getResource("Image/down1.png")).getImage();
        animation[2][1] = new ImageIcon(this.getClass().getResource("Image/down2.png")).getImage();
        animation[2][2] = new ImageIcon(this.getClass().getResource("Image/down3.png")).getImage();
        animation[3][0] = new ImageIcon(this.getClass().getResource("Image/left1.png")).getImage();
        animation[3][1] = new ImageIcon(this.getClass().getResource("Image/left2.png")).getImage();
        animation[3][2] = new ImageIcon(this.getClass().getResource("Image/left3.png")).getImage();
    }

    public void updatePosition(){
        moving = false;
        if (left && !right && CheckCollide(x-speed, y, gamePanel.getGame().getMap())) {x-= speed; moving = true; playerdir=LEFT;}
        else if (right && !left && CheckCollide(x+speed, y, gamePanel.getGame().getMap())) {x+= speed; moving = true; playerdir=RIGHT;}

        if (up && !down && CheckCollide(x, y-speed, gamePanel.getGame().getMap())) {y-= speed; moving = true; playerdir=UP;}
        else if (down && !up && CheckCollide(x, y+speed, gamePanel.getGame().getMap())) {y+= speed; moving = true; playerdir=DOWN;}
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


    public void render(Graphics g){
        g.drawImage(animation[playerdir][aniIndex], x+1, y+1, 43, 43, null);
    }
    
    
}