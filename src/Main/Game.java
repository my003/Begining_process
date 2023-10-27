package Main;

public class Game {
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private LoadMap load;

    public Game(){
        load = new LoadMap();
        gamePanel = new GamePanel(load);
        gameWindow = new GameWindow(gamePanel);
    }
}
