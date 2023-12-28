package GameState;

import Main.Game;
import UI.MenuButton;
import UI.CreditButton;
import java.awt.event.MouseEvent;

public class State {
    protected Game game;
    public State (Game game){
        this.game = game;
    }
    public boolean isIn(MouseEvent e, MenuButton mb){
        return mb.getBounds().contains(e.getX(), e.getY());
    }
    public boolean isIn1(MouseEvent e, CreditButton cb){
        return cb.getBounds().contains(e.getX(), e.getY());
    }
    public Game getGame(){
        return game;
    }
}