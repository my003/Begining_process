/*
    Name: 16 (BOM IT)
    Member names & IU code:
        ITCSIU21204 -  Nguyen Huynh Thao My
        ITCSIU21219 -  Do Dinh Phuc
        ITITWE20021 -  Nguyen Tran Nguyen Anh
        ITCSIU21063 -  Le Thu Hoang
    Purpose: Set up the Mouse input for pressing buttons on each state.
*/
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
    public void mouseDragged(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {
        switch (GameStates.state) {
            case MENU -> gamePanel.getGame().getMenu().mouseMoved(e);
            case PLAY -> gamePanel.getGame().getPlay().mouseMoved(e);
            case CREDIT -> gamePanel.getGame().getCredit().mouseMoved(e);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {}
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
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}