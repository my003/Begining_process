package Main;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;




public class GamePanel extends JPanel {
    private Image backGround;
    private Game game;

    public GamePanel(Game game){
        this.game = game;
        addKeyListener(new KeyBoardInput(this));
        importImage();
        getPanelSize();
    }

    private void importImage() {
        backGround = new ImageIcon(this.getClass().getResource("Image/background_Play3.png")).getImage();
    }

    private void getPanelSize() {   
        Dimension size = new Dimension(947, 675);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    public void paintComponent(Graphics g){
        g.drawImage(backGround, 0, 0, null);
        game.render(g);
    }

    public Game getGame(){
        return game;
    }
}
