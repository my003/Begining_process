package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardInput implements KeyListener{
    private GamePanel gamepanel;

    public KeyBoardInput(GamePanel gamepanel){
        this.gamepanel = gamepanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
            gamepanel.getGame().getPlayer().setUp(true);
            break;
            case KeyEvent.VK_D:
            gamepanel.getGame().getPlayer().setRight(true);
            break;
            case KeyEvent.VK_S:
            gamepanel.getGame().getPlayer().setDown(true);
            break;
            case KeyEvent.VK_A:
            gamepanel.getGame().getPlayer().setLeft(true);
            break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
            gamepanel.getGame().getPlayer().setUp(false);
            break;
            case KeyEvent.VK_D:
            gamepanel.getGame().getPlayer().setRight(false);
            break;
            case KeyEvent.VK_S:
            gamepanel.getGame().getPlayer().setDown(false);
            break;
            case KeyEvent.VK_A:
            gamepanel.getGame().getPlayer().setLeft(false);
            break;
        }
    }
    
}
