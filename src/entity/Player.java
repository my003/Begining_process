package entity;

import GameState.Play;
import Main.Bomb;
import Main.BombAdapter;
import Main.GamePanel;
import Main.KeyBoardInput;
import entity.Entity;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

import static Main.Constant.AnimationConstant.*;

import static Main.Check.CheckCollide;

public class Player extends Entity {

    private int playerNumber;

    KeyBoardInput keyBoardInput;

    private int speed = 1;
    private int speednormal = 1;
    private int speedsqueeze = 1;
    private int freezing = 0;
    private int health = 1000;
    private int maxbom = 1;
    private int damage = 1;
//    private boolean winner1 = false, winner2 = false;

    private int aniTick = 0, aniSpeed = 50, aniIndex =0;
    boolean moving = false;
    private int playerdir = UP;

    private boolean up, right, down, left;

    private ArrayList<Bomb> bombs;
    private BombAdapter bombAdapter;

    private JProgressBar bar;

    private Image animation1[][],animation2[][];

    GamePanel gamePanel;

    public Player(int x, int y, GamePanel gamePanel, int playerNumber){
        super(x,y);
        rectangle = new Rectangle(x+6, y+6, 33, 33);
        this.gamePanel = gamePanel;
        if (playerNumber == 1)
            barhealth1();
        else
            barhealth2();
        gamePanel.add(bar);
        loadAnimation1();
        loadAnimation2();
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

    private void loadAnimation1() {
        animation1 = new Image[4][4];
        animation1[0][0] = new ImageIcon(this.getClass().getResource("player1/back1.png")).getImage();
        animation1[0][1] = new ImageIcon(this.getClass().getResource("player1/back2.png")).getImage();
        animation1[0][2] = new ImageIcon(this.getClass().getResource("player1/back3.png")).getImage();
        animation1[0][3] = new ImageIcon(this.getClass().getResource("player1/back4.png")).getImage();
        animation1[1][0] = new ImageIcon(this.getClass().getResource("player1/right1_1.png")).getImage();
        animation1[1][1] = new ImageIcon(this.getClass().getResource("player1/right2_1.png")).getImage();
        animation1[1][2] = new ImageIcon(this.getClass().getResource("player1/right3_1.png")).getImage();
        animation1[1][3] = new ImageIcon(this.getClass().getResource("player1/right4_1.png")).getImage();
        animation1[2][0] = new ImageIcon(this.getClass().getResource("player1/front1.png")).getImage();
        animation1[2][1] = new ImageIcon(this.getClass().getResource("player1/front2.png")).getImage();
        animation1[2][2] = new ImageIcon(this.getClass().getResource("player1/front3.png")).getImage();
        animation1[2][3] = new ImageIcon(this.getClass().getResource("player1/front4.png")).getImage();
        animation1[3][0] = new ImageIcon(this.getClass().getResource("player1/left1_1.png")).getImage();
        animation1[3][1] = new ImageIcon(this.getClass().getResource("player1/left2_1.png")).getImage();
        animation1[3][2] = new ImageIcon(this.getClass().getResource("player1/left3_1.png")).getImage();
        animation1[3][3] = new ImageIcon(this.getClass().getResource("player1/left4_1.png")).getImage();
    }
    private void loadAnimation2() {
        animation2 = new Image[4][3];
        animation2[0][0] = new ImageIcon(this.getClass().getResource("player2/back.png")).getImage();
        animation2[0][1] = new ImageIcon(this.getClass().getResource("player2/back1.png")).getImage();
        animation2[0][2] = new ImageIcon(this.getClass().getResource("player2/back2.png")).getImage();
        animation2[1][0] = new ImageIcon(this.getClass().getResource("player2/right.png")).getImage();
        animation2[1][1] = new ImageIcon(this.getClass().getResource("player2/right1.png")).getImage();
        animation2[1][2] = new ImageIcon(this.getClass().getResource("player2/right2.png")).getImage();
        animation2[2][0] = new ImageIcon(this.getClass().getResource("player2/front.png")).getImage();
        animation2[2][1] = new ImageIcon(this.getClass().getResource("player2/front1.png")).getImage();
        animation2[2][2] = new ImageIcon(this.getClass().getResource("player2/front2.png")).getImage();
        animation2[3][0] = new ImageIcon(this.getClass().getResource("player2/left.png")).getImage();
        animation2[3][1] = new ImageIcon(this.getClass().getResource("player2/left1.png")).getImage();
        animation2[3][2] = new ImageIcon(this.getClass().getResource("player2/left2.png")).getImage();
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

    private void barhealth1() {
        bar = new JProgressBar(0, 1000);
        String s = String.valueOf(health);
        bar.setString(s);
        //bar.setBounds(887, 20, 200, 40);
        //bar.setForeground(new Color(178, 236, 115));
        bar.setBackground(Color.BLACK);
        bar.setValue(health);
        if (bar.getValue() < 0) Play.winner = 2;
    }
    public int getBarHealth(){
        return bar.getValue();
    }
    private void barhealth2() {
        bar = new JProgressBar(0, 1000);
        String s = String.valueOf(health);
        bar.setString(s);
        //bar.setBounds(887, 20, 200, 40);
        //bar.setForeground(new Color(178, 236, 115));
        bar.setBackground(Color.BLACK);
        bar.setValue(health);
        if (bar.getValue() < 0) Play.winner = 1;
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
        if (playerNumber == 1)
            g.drawImage(animation1[playerdir][aniIndex], x+1, y+1, 43, 43, null);
        else
            g.drawImage(animation2[playerdir][aniIndex], x+1, y+1, 43, 43, null);

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
        return speednormal;
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
    public int getDrug(){
        return damage;
    }
    public void beExploded(int damage){
        health-=damage;
        bar.setValue(health);
//        if (health <= 0) {
//            if (playerNumber == 1)
//                winner1 = true;
//            if (playerNumber == 2)
//                winner2 = true;
//        }
    }

    public int getRow(){
        return (y-45)/45;
    }

    public int getCol() { return (x-45)/45; }
}