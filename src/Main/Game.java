package Main;

import java.awt.Graphics;

public class Game implements Runnable{
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private LoadMap load;
    private final int FPS = 100 , UPS = 200;
    private Thread thread;

    private Player player;

    public Game(){
        load = new LoadMap();
        player = new Player(400, 400);
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
        startgameloop();
    }

    private void startgameloop() {
        thread = new Thread(this);
        thread.start();
    }

    public void update(){
        player.update();
    }

    public void render(Graphics g){
        load.draw(g);
        player.render(g);
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

    public Player getPlayer(){
        return player;
    }

    public LoadMap getMap(){
        return load;
    }
}
