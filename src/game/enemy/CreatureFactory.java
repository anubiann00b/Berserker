package game.enemy;

import asciiPanel.AsciiPanel;
import game.enemy.ai.KoboldAi;
import game.enemy.ai.PlantAi;
import game.player.FieldOfView;
import game.player.Player;
import game.player.PlayerAi;
import game.world.World;
 
public class CreatureFactory {
    private World world;
 
    public CreatureFactory(World world) {
        this.world = world;
    }
    
    public Player newPlayer(FieldOfView fov) {
        Player player = new Player(world,10,10,3);
        world.spawnPlayer(player);
        new PlayerAi(player,fov);
        return player;
    }
    
    public Creature newPlant() {
        Creature plant = new Creature("plant", world,'P',AsciiPanel.green,5,2);
        world.addAtEmptyLocation(plant);
        new PlantAi(plant);
        return plant;
    }
    
    public Creature newKobold(FieldOfView fov, Player player) {
        Creature kobold = new Creature("kobold", world,'K',AsciiPanel.brightYellow,10,6);
        do { world.addAtEmptyLocation(kobold); }
        while (Math.pow(kobold.getX()-player.getX(),2)+Math.pow(kobold.getY()-player.getY(),2)<81);
        new KoboldAi(kobold, player);
        return kobold;
    }
}