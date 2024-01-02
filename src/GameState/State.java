/*
    Name: 16 (BOM IT)
    Member names & IU code:
        ITCSIU21204 -  Nguyen Huynh Thao My
        ITCSIU21219 -  Do Dinh Phuc
        ITITWE20021 -  Nguyen Tran Nguyen Anh
        ITCSIU21063 -  Le Thu Hoang
    Purpose: Create methods for another states extend.
*/
package GameState;

import Main.Game;
import UI.*;

import java.awt.event.MouseEvent;

public class State {
    protected Game game;
    public State (Game game){
        this.game = game;
    }
    public boolean isIn(MouseEvent e, MenuButton mb) { return mb.getBounds().contains(e.getX(), e.getY()); }
    public Game getGame(){
        return game;
    }
    public static void setGamestate(GameStates state) { GameStates.state = state; }
}
