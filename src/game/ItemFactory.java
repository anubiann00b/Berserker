package game;

public class ItemFactory {
    private World world;
    
    public ItemFactory(World world) {
        this.world = world;
    }
    
    public GroundedItem spawnItem() {
        GroundedItem item = new GroundedItem(new Item());
        world.addAtEmptyLocation(item);
        return item;
    }
}