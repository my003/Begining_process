package entity;

import Main.Bomb;
import Main.BombAdapter;
import Main.GamePanel;
import Main.KeyBoardInput;

import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.util.*;

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

    private boolean end = false;
    private int move = 0, next = 1, nextt = 0;
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
        //init();
    }
    public void init() {
        dr = new int[] {-1, 1, 0, 0};
        dc = new int[] {0, 0, -1, 1};
        visited = new boolean[13][15];
        for (int i = 0; i < 13 ; i++)
            for (int j = 0; j < 15; j++)
                visited[i][j] = false;
        visited[getRow()][getCol()] = true;
        sr = 0;
        sc = 1;
        boolean[][] visited = new boolean[13][15];
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(sr,sc, 0));
        visited[sr][sc] = true;

    }
    class Point {
        int row;
        int col;
        int dist;

        Point(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    private boolean isValid(int[][] matrix, boolean[][] visited, int row, int col, int rows, int cols) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            return !visited[row][col] && matrix[row][col] == 1;
        }
        return false;
    }
//    static List<Point> shortestPathWithTraceback(int[][] matrix, int startRow, int startCol, int endRow, int endCol) {
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//
//        boolean[][] visited = new boolean[rows][cols];
//        int[][] parent = new int[rows][cols]; // Ma trận lưu trữ các điểm trước đó
//        Queue<Point> queue = new LinkedList<>();
//
//        queue.add(new Point(startRow, startCol, 0));
//        visited[startRow][startCol] = true;
//        parent[startRow][startCol] = -1;
//
//        while (!queue.isEmpty()) {
//            Point current = queue.poll();
//
//            if (current.row == endRow && current.col == endCol) {
//                List<Point> path = new ArrayList<>();
//                int r = current.row, c = current.col;
//                while (parent[r][c] != -1) {
//                    path.add(new Point(r, c, 0));
//                    int tempR = parent[r][c] / cols;
//                    int tempC = parent[r][c] % cols;
//                    r = tempR;
//                    c = tempC;
//                }
//                Collections.reverse(path);
//                return path;
//            }
//
//            for (int i = 0; i < 4; i++) {
//                int newRow = current.row + dr[i];
//                int newCol = current.col + dc[i];
//
//                if (isValid(matrix, visited, newRow, newCol, rows, cols)) {
//                    visited[newRow][newCol] = true;
//                    queue.add(new Point(newRow, newCol, current.dist + 1));
//                    parent[newRow][newCol] = current.row * cols + current.col; // Lưu trữ vị trí trước đó
//                }
//            }
//        }
//
//        return new ArrayList<>();
//    }
    public int shortestPath(int[][] matrix) {
        int startRow = 0, startCol = 0, endRow = 0, endCol = 6;
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int[][] parent = new int[rows][cols]; // Ma trận lưu trữ các điểm trước đó
        Queue<Point> queue = new LinkedList<>();

        // up, down, left, right
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        for (int i = 0; i < 13 ; i++)
            for (int j = 0; j < 15; j++)
                parent[i][j] = -1;
        parent[startRow][startCol] = 0;
        queue.add(new Point(startRow, startCol, 0));
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.row == endRow && current.col == endCol) {
                return current.dist;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = current.row + dr[i];
                int newCol = current.col + dc[i];

                if (isValid(matrix, visited, newRow, newCol, rows, cols) && map[newRow][newCol] == 1) {
                    queue.add(new Point(newRow, newCol, current.dist + 1));
                    parent[newRow][newCol] = current.row * cols + current.col; // Lưu trữ vị trí trước đó
                }
            }
        }
        for (int i = 0 ; i < 13 ; i++){
            for (int j = 0 ; j < 15 ; j++)
//                if (visited[i][j])
//                    System.out.print(1 + " ");
//                else
                System.out.print(parent[i][j] + " ");
            System.out.println();
            }
        Queue<Point> path = new LinkedList<>();
        int row = startRow;
        int col = startCol;
        int tile = parent[row][col];
        //path.add(new Point(row,col));

        while (row != endRow && col != endRow){
            if (parent[row+1][col] == tile+1) {
                row++;
                visited[row][col] = true;
            }
            else
                if (parent[row-1][col] == tile+1) {
                    row--;
                    visited[row][col] = true;
                }
                else
                    if (parent[row][col+1] == tile+1) {
                        col++;
                        visited[row][col] = true;
                    }
                    else
                        if (parent[row][col-1] == tile+1) {
                            col--;
                            visited[row][col] = true;
                        }
                        else
                        {
                            row = -1;
                            col = -1;
                            path.remove();
                        }
//            if (row != -1 && col != -1)
//                path.add(new Point(row,col));
        }
        for (int i = 0 ; i < 13 ; i++){
            for (int j = 0 ; j < 15 ; j++)
                if (visited[i][j])
                    System.out.print("1 ");
                else
                    System.out.print("0 ");
            System.out.println();
        }
        return -1; // Not found
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

    public void updateAnitick(){}

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
