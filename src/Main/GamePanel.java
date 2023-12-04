package Main;

import State.State;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.*;


public class GamePanel extends JPanel {
    private Image backGround;
    private Game game;
    public GamePanel(Game game){
        this.game = game;
        addKeyListener(new KeyBoardInput(this));
        addMouseMotionListener(game);
        addMouseListener(game);
        setFocusable(true);
        requestFocus();
        importImage();
        getPanelSize();

    }

    private void importImage() {
        //backGround = new ImageIcon(this.getClass().getResource("Image/backbround.jpg")).getImage();
        backGround = new ImageIcon(this.getClass().getResource("Image/background_Play3.png")).getImage();
    }


    private void getPanelSize() {   
        Dimension size = new Dimension(947, 675);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    public void paintComponent(Graphics g){
        game.render(g);
    }
    public Game getGame(){
        return game;
    }
}
