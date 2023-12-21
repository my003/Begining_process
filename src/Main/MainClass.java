package Main;

public class MainClass {
public static void main(String[] args) {
    Game game = new Game();
    new GameThread1(game);
    new GameThread2(game);
}

}