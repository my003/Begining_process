package Main;

import entity.Boss;

import java.util.LinkedList;
import java.util.Queue;

import static GameState.Play.reset;

public class MainClass {
    public static void main(String[] args) {
        Game game = new Game();
        game.initPlay();
        new GameThread1(game);
        new GameThread2(game);
    }
}