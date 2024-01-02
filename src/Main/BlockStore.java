/*
    Name: 16 (BOM IT)
    Member names & IU code:
        ITCSIU21204 -  Nguyen Huynh Thao My
        ITCSIU21219 -  Do Dinh Phuc
        ITITWE20021 -  Nguyen Tran Nguyen Anh
        ITCSIU21063 -  Le Thu Hoang
    Purpose: Controlling the creation of Stone Block and WoodBlock, item and trap base on extension of block.
*/
package Main;

public class BlockStore {

    public static Block createBlock(String blockname, int x, int y){
        Block block = null;
        switch (blockname) {
            case "Stone":
                block = new StoneBlock(x, y);
                break;
            case "Wood":
                block = new WoodBlock(x, y);
                break;
            default:
                break;
        }
        return block;
    }

    public static Block createItem_Trap(String name, int x, int y){
        Block block = null;
        switch (name) {
            case "Shoe":
                block = new ShoeItem(x, y);
                break;
            case "Bomb":
                block = new BombItem(x, y);
                break;
            case "Drug":
                block = new DrugItem(x, y);
                break;
            case "Fire":
                block = new FireTrap(x, y);
                break;
            case "Ice":
                block = new IceTrap(x, y);
                break;
            default:
                break;
        }
        return block;
    }
}