package Main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import java.awt.Color;

import static Main.Constant.AnimationConstant.*;

import static Main.Check.CheckCollide;

public class Player extends Entity{

    private int playerNumber;

    KeyBoardInput keyBoardInput;

    private int speed = 1;
    private int speednormal = 1;
    private int speedsqueeze = 1;
    private int freezing = 0;
    private int health = 1000;
    private int maxbom = 1;
    private int damage = 1;

    private int aniTick = 0, aniSpeed = 50, aniIndex =0;
    boolean moving = false;
    private int playerdir = UP;

    private boolean up, right, down, left;

    private ArrayList<Bomb> bombs;
    private BombAdapter bombAdapter;

    private JProgressBar bar;

    private Image animation[][];

    GamePanel gamePanel;

    public Player(int x, int y, GamePanel gamePanel, int playerNumber){
        super(x,y);
        rectangle = new Rectangle(x+6, y+6, 33, 33);
        this.gamePanel = gamePanel;
        barhealth();
        gamePanel.add(bar);
        loadAnimation();
        loadbomb(maxbom);
        bombAdapter = new BombAdapter(gamePanel, playerNumber);
        this.playerNumber = playerNumber;
        keyBoardInput = new KeyBoardInput(gamePanel, playerNumber);
    }

    private void loadbomb(int maxbom2) {
        bombs = new ArrayList<>();
        for (int i=0; i<maxbom2; ++i){
            Bomb bomb = new Bomb(-1000, -1000, damage, damage);
            bombs.add(bomb);
        }
    }

    private void addNewBomb(){
        Bomb bomb; 
        if (damage>3) bomb = new Bomb(-1000, -1000, damage, 3);
        else bomb = new Bomb(-1000, -1000, damage, damage);
        bombs.add(bomb);
        gamePanel.getGame().getData().addExplosion(bomb);
    }

    public void setBomb(){
        bombAdapter.addBomb();
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

        rectangle.setLocation(x+6, y+6);
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

    private void freezing(){
        if (freezing>0) {speed = speedsqueeze; freezing--;}
        else {speed = speednormal;}
    }

    public void update(){
        updatePosition();
        updateAnitick();
        bombAdapter.reviseBomb();
        freezing();
    }

        private void barhealth() {
        bar = new JProgressBar(0, 1000);
        bar.setBounds(680, 20, 300, 40);
        bar.setForeground(new Color(178, 236, 115));
        bar.setBackground(Color.GRAY);
        bar.setValue(health);
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

    public BombAdapter getBombAdapter(){
        return bombAdapter;
    }
    
    public KeyBoardInput getKeyBoardInput(){
        return keyBoardInput;
    }

    public int getSpeed(){
        return speed;
    }

    public void setProperty(String trap){
        switch (trap) {
            case "Fire":
                health-=3;
                bar.setValue(health);
                break;
            case "Ice":
                freezing = 100;
                break;
            case "BombItem":
                addNewBomb();
                break;
            case "ShoeItem":
                speed+=1;
                speednormal+=1;
                break;
            case "DrugItem":
                damage++;
                for (Bomb bomb:bombs) bomb.buffBomb();
                for (Bomb bomb:bombAdapter.getBombs()) bomb.buffBomb();
        }
    }
    public void beExploded(int damage){
        health-=damage;
        bar.setValue(health);
    }

    public int getRow(){
        return (y-45)/45;
    }
}