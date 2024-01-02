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

public class GameThread1 implements Runnable{
    private Game game;
    private Thread thread;

    private final int UPS1 = 160;

    public GameThread1(Game game){
        this.game = game;
        startgameloop();
    }

    private void startgameloop(){
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        double timeperupdate1 = 1000000000.0/UPS1;
        long previous = System.nanoTime();
        double deltaU1 = 0;

        while (true) {
            long current = System.nanoTime();
            deltaU1 += (current - previous) / timeperupdate1;
            previous = current;

            if (deltaU1>=1) {deltaU1--; game.update();}
        }
    }
}