package Main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.awt.Image;

import javax.swing.ImageIcon;

import static Main.Constant.AnimationConstant.*;

import static Main.Check.CheckCollide;

public class Player extends Entity{

    private int speed = 1;
    private int health;
    private int maxbom = 6;
    private int damage = 3;

    private int aniTick = 0, aniSpeed = 50, aniIndex =0;
    boolean moving = false;
    private int playerdir = UP;

    private boolean up, right, down, left;

    private ArrayList<Bomb> bombs;
    private BombAdapter bombAdapter;

    private Image animation[][];

    GamePanel gamePanel;

    public Player(int x, int y, GamePanel gamePanel){
        super(x,y);
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

    private void loadAnimation() {
        animation = new Image[4][4];
        animation[0][0] = new ImageIcon(this.getClass().getResource("Image/front1.png")).getImage();
        animation[0][1] = new ImageIcon(this.getClass().getResource("Image/front2.png")).getImage();
        animation[0][2] = new ImageIcon(this.getClass().getResource("Image/front3.png")).getImage();
        animation[0][2] = new ImageIcon(this.getClass().getResource("Image/front4.png")).getImage();

        animation[1][0] = new ImageIcon(this.getClass().getResource("Image/right1_1.png")).getImage();
        animation[1][1] = new ImageIcon(this.getClass().getResource("Image/right2_1.png")).getImage();
        animation[1][2] = new ImageIcon(this.getClass().getResource("Image/right3_1.png")).getImage();
        animation[1][2] = new ImageIcon(this.getClass().getResource("Image/right4_1.png")).getImage();

        animation[2][0] = new ImageIcon(this.getClass().getResource("Image/back1.png")).getImage();
        animation[2][1] = new ImageIcon(this.getClass().getResource("Image/back2.png")).getImage();
        animation[2][2] = new ImageIcon(this.getClass().getResource("Image/back3.png")).getImage();
        animation[2][2] = new ImageIcon(this.getClass().getResource("Image/back4.png")).getImage();

        animation[3][0] = new ImageIcon(this.getClass().getResource("Image/left1_1.png")).getImage();
        animation[3][1] = new ImageIcon(this.getClass().getResource("Image/left2_1.png")).getImage();
        animation[3][2] = new ImageIcon(this.getClass().getResource("Image/left3_1.png")).getImage();
        animation[3][2] = new ImageIcon(this.getClass().getResource("Image/left4_1.png")).getImage();

    }

    public void updatePosition(){
        moving = false;
        if (left && !right && CheckCollide(x-speed, y, gamePanel.getGame().getMap())) {x-= speed; moving = true; playerdir=LEFT;}
        else if (right && !left && CheckCollide(x+speed, y, gamePanel.getGame().getMap())) {x+= speed; moving = true; playerdir=RIGHT;}

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


    public void render(Graphics g){
        g.drawImage(animation[playerdir][aniIndex], x+1, y+1, 43, 43, null);
    }

    public ArrayList<Bomb> getBombs(){
        return bombs;
    }

    public Rectangle getRectangle(){
        return rectangle;
    }

}