/*
    Name: 16 (BOM IT)
    Member names & IU code:
        ITCSIU21204 -  Nguyen Huynh Thao My
        ITCSIU21219 -  Do Dinh Phuc
        ITITWE20021 -  Nguyen Tran Nguyen Anh
        ITCSIU21063 -  Le Thu Hoang
    Purpose:
*/
package Main;
public class Data extends Subject{

    public Data(GamePanel gamePanel){
        super(gamePanel);
        addData();
    }

    public void addData() {
        for (Block fire: fires){
            fire.setData(this);
        }
        for (Block ice: ices){
            ice.setData(this);
        }
        for (Block item: items){
            item.setData(this);
        }
        for (Explosion explosion: explosions){
            explosion.setData(this);
        }
    }

    public void trap(String trap, int i){
        notifyPlayer(trap, i);
    }

    public void explode(int damage, int i){
        explodePlayer(damage, i);
    }
}