package game.enemy.ai;

import asciiPanel.AsciiPanel;
import game.enemy.Creature;
import game.player.Player;
import game.world.Tile;
import java.awt.Color;

public class KoboldAi extends CreatureAi {
    
    private Player player;
    
    public KoboldAi(Creature creature, Player player) {
        super(creature);
        this.player = player;
    }
    
    @Override
    public void onEnter(int x, int y, Tile tile) {
        if (tile.isPassable()) {
            creature.setX(x);
            creature.setY(y);
        }
    }
        
    @Override
    public void update() {
        if (creature.canSee(player.getX(),player.getY()))
            hunt();
        else
            wander();
    }
    
    private void hunt() {
        int ox = creature.getX()-player.getX();
        int oy = creature.getY()-player.getY();
        int xIndex = 0;
        int yIndex = 0;
        if (ox>0) {
            xIndex--;
        } else if (ox<0) {
            xIndex++;
        }
        if (oy>0) {
            yIndex--;
        } else if (oy<0) {
            yIndex++;
        }
        creature.moveBy(xIndex,yIndex);
    }
    
    @Override
    public void addCritMessage(Player other) {
        other.addMessage("The kobold pulls off a devasting attack!",AsciiPanel.brightRed);
    }
    
    @Override
    public void addCritMissMessage(Player other) {
        other.addMessage("The kobold swings wildly.",Color.LIGHT_GRAY);
    }
    
    @Override
    public void addMissMessage(Player other) {
        other.addMessage("The kobold barely misses you.",Color.WHITE);
    }
    
    @Override
    public void addHitMessage(Player other) {
        other.addMessage("The kobold hits you.",AsciiPanel.red);
    }
}
