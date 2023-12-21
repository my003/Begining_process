package Main;

public class GameThread1 implements Runnable{
    private Game game;
    private Thread thread;

    private final int UPS1 = 150;
    private final int UPS2 = 150;
    private final int UPS3 = 180;

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
        double timeperupdate2 = 1000000000.0/UPS2;
        double timeperupdate3 = 1000000000.0/UPS3;
        long previous = System.nanoTime();
        double deltaU1 = 0;
        double deltaU2 = 0;
        double deltaU3 = 0;

        while (true) {
            long current = System.nanoTime();
            deltaU1 += (current - previous) / timeperupdate1;
            deltaU2 += (current - previous) / timeperupdate2;
            deltaU3 += (current - previous) / timeperupdate3;
            previous = current;

            if (deltaU1>=1) {deltaU1--; game.update1();}
            if (deltaU2>=1) {deltaU2--; game.update2();}
            if (deltaU3>=1) {deltaU3--; game.update3();}
        }
    }
}
