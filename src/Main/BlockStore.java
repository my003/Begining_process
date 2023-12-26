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