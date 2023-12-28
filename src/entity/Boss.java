package entity;

import Main.Bomb;
import Main.BombAdapter;
import Main.GamePanel;
import Main.KeyBoardInput;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static Main.Check.CheckCollide;
import static Main.Constant.AnimationConstant.*;

public class Boss extends Entity{
    private int bossNumber;
    private int speed = 1;
    private int health = 1000;
    private int R = 13, C = 15;
    private int sr, sc;
    private Queue<Integer> rq = new LinkedList<>();
    private Queue<Integer> cq = new LinkedList<>();

    private int move = 0, next = 1, nextt = 0;
    private boolean end = false;
    private boolean[][] visited;
    private int[] dr,dc;
    boolean moving = false;
    private int playerdir = UP;
    private boolean up, right, down, left;
    private JProgressBar bar;

    private Image animation[][];

    private int[][] map;

    GamePanel gamePanel;

    public Boss(int x, int y, GamePanel gamePanel, int bossNumber){
        super(x,y);
        rectangle = new Rectangle(x+6, y+6, 33, 33);
        this.gamePanel = gamePanel;
        loadAnimation();
        this.bossNumber = bossNumber;
        map = gamePanel.getGame().getMap().getMapIndex();
        check();
    }
    public void init() {
        dr = new int[4];
        dr[0] = -1;
        dr[1] = 1;
        dr[2] = 0;
        dr[3] = 0;
        dc = new int[4];
        dc[0] = 0;
        dc[1] = 0;
        dc[2] = 1;
        dc[3] = -1;
        visited = new boolean[13][15];
        for (int i = 0; i < 13 ; i++)
            for (int j = 0; j < 15; j++)
                visited[i][j] = false;
        visited[getRow()][getCol()] = true;
        sr = 0;
        sc = 1;
    }
    public void check(){
        init();
        //solve();
        System.out.println(solve());

    }
    public void neighbours(int row, int col){
        for (int i = 0 ; i < 4; i++){
            int rr = row + dr[i];
            int cc = col + dc[i];

            if (rr < 0 || cc < 0) continue;
            if (rr >= R || cc >= C) continue;

            if (visited[rr][cc]) continue;
            if (map[rr][cc] == 3) continue;
            if (map[rr][cc] == 4) continue;

            rq.add(rr);
            cq.add(cc);
            visited[rr][cc] = true;
            nextt++;
        }
    }
    public int solve(){
        rq.add(sr);
        cq.add(sc);
        visited[sr][sc] = true;
        while (rq.size() > 0){
            int r = rq.poll();
            int c = cq.poll();
            if (map[r][c] == 0){
                end = true;
                break;
            }
            neighbours(r,c);
            next--;
            if (next == 0){
                next = nextt;
                nextt = 0;
                move++;
            }
            if (end)
                return move;
        }
        return -1;
    }

    private void loadAnimation() {
        animation = new Image[4][1];
        animation[0][0] = new ImageIcon(this.getClass().getResource("boss/ghost/ghost_up.png")).getImage();
        animation[1][0] = new ImageIcon(this.getClass().getResource("boss/ghost/ghost_right.png")).getImage();
        animation[2][0] = new ImageIcon(this.getClass().getResource("boss/ghost/ghost_down.png")).getImage();
        animation[3][0] = new ImageIcon(this.getClass().getResource("boss/ghost/ghost_left.png")).getImage();
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
    }

    public void update(){
        updatePosition();
    }

    private void barhealth() {
        bar = new JProgressBar(0, 1000);
        bar.setBounds(680, 20, 300, 40);
        bar.setForeground(new Color(178, 236, 115));
        bar.setBackground(Color.GRAY);
        bar.setValue(health);
    }

    public void setUp(boolean isUp){up = isUp;}
    public void setRight(boolean isRight){right = isRight;}
    public void setDown(boolean isDown){down = isDown;}
    public void setLeft(boolean isLeft){left = isLeft;}
    public void render(Graphics g){
       g.drawImage(animation[0][0], x+1, y+1, 43, 43, null);
    }
    public Rectangle getRectangle(){
        return rectangle;
    }


    public int getSpeed(){
        return speed;
    }
    public int getRow(){
        return (y-45)/45;
    }
    public int getCol() {return (x-45)/45; }
}
