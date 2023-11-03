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
}
