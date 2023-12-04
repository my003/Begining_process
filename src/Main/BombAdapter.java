package Main;


public class BombAdapter {
    private GamePanel gamePanel;
    private int timeLife = 101;


    public BombAdapter(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void addBomb(){
        if (gamePanel.getGame().getPlayer().getBombs().size()>0 && timeLife>100){
        timeLife = 500;
        gamePanel.getGame().getPlayer().getBombs().get(0).setLocation(((gamePanel.getGame().getPlayer().x+21-45)/45), ((gamePanel.getGame().getPlayer().y+32-45)/45));
        gamePanel.getGame().getMap().getBombs().add(gamePanel.getGame().getPlayer().getBombs().remove(0));
        }
    }

    public void reviseBomb(){
        if (gamePanel.getGame().getMap().getBombs().size()>0) {timeLife--; sensor();}
        if (timeLife==100) {
            gamePanel.getGame().getMap().setExplosion(true);
        }
        if (timeLife==0) {
            gamePanel.getGame().getMap().setExplosion(false);
            while (gamePanel.getGame().getMap().getBombs().size()>0) 
                {gamePanel.getGame().getMap().getBombs().get(0).setPermitCollide(true); 
                gamePanel.getGame().getMap().getBombs().get(0).resetExplosion();
                gamePanel.getGame().getPlayer().getBombs().add(gamePanel.getGame().getMap().getBombs().remove(0));}
            timeLife = 101;
        }
    }

    public void sensor(){
        for (Bomb bomb: gamePanel.getGame().getMap().getBombs() )
            if (bomb.getPermitCollide() && !bomb.isCollide(gamePanel.getGame().getPlayer().getRectangle())){
                bomb.setPermitCollide(false);
            }
    }


}
