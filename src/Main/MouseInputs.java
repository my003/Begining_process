package Main;

import GameState.GameStates;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInputs implements MouseListener, MouseMotionListener {

    private GamePanel gamePanel;

    public MouseInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        switch (GameStates.state) {
            case MENU -> gamePanel.getGame().getMenu().mouseMoved(e);
            case PLAY -> gamePanel.getGame().getPlay().mouseMoved(e);
            case CREDIT -> gamePanel.getGame().getCredit().mouseMoved(e);
        }
    }

    @SuppressWarnings("incomplete-switch")
    @Override
    public void mouseClicked(MouseEvent e) {
//        switch (Gamestate.state) {
//            case PLAYING -> gamePanel.getGame().getPlaying().mouseClicked(e);
//        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (GameStates.state) {
            case MENU -> gamePanel.getGame().getMenu().mousePressed(e);
            case PLAY -> gamePanel.getGame().getPlay().mousePressed(e);
            case CREDIT -> gamePanel.getGame().getCredit().mousePressed(e);
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        switch (GameStates.state) {
            case MENU -> gamePanel.getGame().getMenu().mouseReleased(e);
            case PLAY -> gamePanel.getGame().getPlay().mouseReleased(e);
            case CREDIT -> gamePanel.getGame().getCredit().mouseReleased(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Not In use
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Not In use
    }

}