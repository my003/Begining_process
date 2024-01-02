/*
    Name: 16 (BOM IT)
    Member names & IU code:
        ITCSIU21204 -  Nguyen Huynh Thao My
        ITCSIU21219 -  Do Dinh Phuc
        ITITWE20021 -  Nguyen Tran Nguyen Anh
        ITCSIU21063 -  Le Thu Hoang
    Purpose:
*/
package Main;

public class GameThread2 implements Runnable{
    private Game game;
    private Thread thread;

    private final int FPS = 120;

    public GameThread2(Game game){
        this.game = game;
        startgameloop();
    }

    private void startgameloop(){
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        double timeperframe = 1000000000.0/FPS;
        long previous = System.nanoTime();
        double deltaF = 0;

        while (true) {
            long current = System.nanoTime();
            deltaF += (current - previous) / timeperframe;
            previous = current;

            if (deltaF>=1) {deltaF--; game.getGamePanel().repaint();}
        }
    }
}