package game;

import asciiPanel.AsciiPanel;
 
public class CreatureFactory {
    private World world;
 
    public CreatureFactory(World world) {
        this.world = world;
    }
    
    public Creature newPlayer(FieldOfView fov) {
        Creature player = new Creature("you", world,'@',AsciiPanel.brightWhite,10,10,5, false);
        world.addAtEmptyLocation(player);
        new PlayerAi(player, fov);
        return player;
    }
    
    public Creature newPlant() {
        Creature plant = new Creature("plant", world,'P',AsciiPanel.green,5,0,2);
        world.addAtEmptyLocation(plant);
        new PlantAi(plant);
        return plant;
    }
    
    public Creature newKobold(FieldOfView fov, Creature player) {
        Creature kobold = new Creature("kobold", world,'K',AsciiPanel.brightRed,15,0,3);
        do { world.addAtEmptyLocation(kobold); }
        while (Math.pow(kobold.getX()-player.getX(),2)+Math.pow(kobold.getY()-player.getY(),2)<81);
        new KoboldAi(kobold, player);
        return kobold;
    }
}