package GameState;

import Main.Game;
import UI.*;

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
    public boolean isIn2(MouseEvent e, PlayButton pb){
        return pb.getBounds().contains(e.getX(), e.getY());
    }
    public boolean isIn3(MouseEvent e, SoundButton sb){
        return sb.getBounds().contains(e.getX(), e.getY());
    }
    public boolean isIn4(MouseEvent e, MusicButton eb){
        return eb.getBounds().contains(e.getX(), e.getY());
    }
    public Game getGame(){
        return game;
    }
}
