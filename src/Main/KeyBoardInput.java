package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static Main.Constant.*;

public class KeyBoardInput implements KeyListener{
    private GamePanel gamepanel;
    private int playerNumber = 1;


    public KeyBoardInput(GamePanel gamepanel, int playerNumber){
        this.gamepanel = gamepanel;
        this.playerNumber = playerNumber;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (playerNumber == 1){
            switch (e.getKeyChar()){
                case Constant.KeySetForPlayer1.SET_BOMB:
                    gamepanel.getGame().getPlayer(playerNumber).setBomb();
                    break;
            }
        }
        else{
            switch (e.getKeyChar()){
                case Constant.KeySetForPlayer2.SET_BOMB:
                    gamepanel.getGame().getPlayer(playerNumber).setBomb();
                    break;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (playerNumber == 1){
            switch (e.getKeyCode()){
                case Constant.KeySetForPlayer1.UP:
                    gamepanel.getGame().getPlayer(playerNumber).setUp(true);
                    break;
                case Constant.KeySetForPlayer1.RIGHT:
                    gamepanel.getGame().getPlayer(playerNumber).setRight(true);
                    break;
                case Constant.KeySetForPlayer1.DOWN:
                    gamepanel.getGame().getPlayer(playerNumber).setDown(true);
                    break;
                case Constant.KeySetForPlayer1.LEFT:
                    gamepanel.getGame().getPlayer(playerNumber).setLeft(true);
                    break;
            }
        }
        else {
            switch (e.getKeyCode()){
                case Constant.KeySetForPlayer2.UP:
                    gamepanel.getGame().getPlayer(playerNumber).setUp(true);
                    break;
                case Constant.KeySetForPlayer2.RIGHT:
                    gamepanel.getGame().getPlayer(playerNumber).setRight(true);
                    break;
                case Constant.KeySetForPlayer2.DOWN:
                    gamepanel.getGame().getPlayer(playerNumber).setDown(true);
                    break;
                case Constant.KeySetForPlayer2.LEFT:
                    gamepanel.getGame().getPlayer(playerNumber).setLeft(true);
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (playerNumber == 1){
            switch (e.getKeyCode()){
                case Constant.KeySetForPlayer1.UP:
                    gamepanel.getGame().getPlayer(playerNumber).setUp(false);
                    break;
                case Constant.KeySetForPlayer1.RIGHT:
                    gamepanel.getGame().getPlayer(playerNumber).setRight(false);
                    break;
                case Constant.KeySetForPlayer1.DOWN:
                    gamepanel.getGame().getPlayer(playerNumber).setDown(false);
                    break;
                case Constant.KeySetForPlayer1.LEFT:
                    gamepanel.getGame().getPlayer(playerNumber).setLeft(false);
                    break;
            }
        }
        else {
            switch (e.getKeyCode()){
                case Constant.KeySetForPlayer2.UP:
                    gamepanel.getGame().getPlayer(playerNumber).setUp(false);
                    break;
                case Constant.KeySetForPlayer2.RIGHT:
                    gamepanel.getGame().getPlayer(playerNumber).setRight(false);
                    break;
                case Constant.KeySetForPlayer2.DOWN:
                    gamepanel.getGame().getPlayer(playerNumber).setDown(false);
                    break;
                case Constant.KeySetForPlayer2.LEFT:
                    gamepanel.getGame().getPlayer(playerNumber).setLeft(false);
                    break;
            }
        }
    }

}