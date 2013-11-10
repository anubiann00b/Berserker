package game;

import asciiPanel.AsciiPanel;
 
public class ItemFactory {
    private World world;
 
    public ItemFactory(World world) {
        this.world = world;
    }
    
    public Creature spawnItems() {
        Creature player = new Creature(world, '@', AsciiPanel.brightWhite,20,10);
        world.addAtEmptyLocation(player);
        new PlayerAi(player, fov);
        return player;
    }
}