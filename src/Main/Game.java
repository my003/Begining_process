package Main;

import java.awt.Graphics;

public class Game implements Runnable{
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private LoadMap load;
    private final int FPS = 100 , UPS = 200;
    private Thread thread;

    private Player player1, player2;

    private Data data;

    public Game(){
        gamePanel = new GamePanel(this);
        load = new LoadMap(gamePanel);
        player1 = new Player(450, 450, gamePanel, 1);
        player2 = new Player(420, 420, gamePanel, 2);
        data = new Data(gamePanel);
        initKeyBoard();
        gameWindow = new GameWindow(gamePanel);
        startgameloop();
    }

    private void initKeyBoard(){
        gamePanel.addKeyListener(player1.getKeyBoardInput());
        gamePanel.addKeyListener(player2.getKeyBoardInput());
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
    }

    private void startgameloop() {
        thread = new Thread(this);
        thread.start();
    }

    public void update(){
        player1.update();
        player2.update();
        data.trapSensor();
    }

    public void render(Graphics g){
        load.draw(g);
        player1.render(g);
        player2.render(g);
        
    }

    @Override
    public void run() {
        double timeperframe = 1000000000.0/FPS;
        double timeperupdate = 1000000000.0/UPS;
        long previous = System.nanoTime();
        double deltaF = 0;
        double deltaU = 0;

        while (true) {
            long current = System.nanoTime();
            deltaF += (current - previous) / timeperframe;
            deltaU += (current - previous) / timeperupdate;
            previous = current;

            if (deltaF>=1) {deltaF--; gamePanel.repaint();}

            if (deltaU>=1) {deltaU--; update();}
        }

    }

    public Player getPlayer(int n){
        if (n == 1)
        return player1;
        return player2;
    }

    public LoadMap getMap(){
        return load;
    }
}
