package game;

import asciiPanel.AsciiPanel;
 
public class CreatureFactory {
    private World world;
 
    public CreatureFactory(World world) {
        this.world = world;
    }
    
    public Creature newPlayer(FieldOfView fov) {
        Creature player = new Creature("you", world,'@',AsciiPanel.brightWhite,20,10,5);
        world.addAtEmptyLocation(player);
        new PlayerAi(player, fov);
        return player;
    }
    
    public Creature newPlant(){
        Creature plant = new Creature("plant", world,'P',AsciiPanel.green,5,5,2);
        world.addAtEmptyLocation(plant);
        new PlantAi(plant);
        return plant;
    }
}