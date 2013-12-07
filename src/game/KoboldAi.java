package game;

import asciiPanel.AsciiPanel;
import java.awt.Color;

public class KoboldAi extends CreatureAi {
    private Player player;
    
    public KoboldAi(Creature creature, Player player) {
        super(creature);
        this.player = player;
    }
    
    public void onEnter(int x, int y, Tile tile) {
        if (tile.isPassable()) {
            creature.setX(x);
            creature.setY(y);
        }
    }
        
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
    
    protected void addCritMessage(Player other) {
        other.addMessage("The kobold pulls off a devasting attack!",AsciiPanel.brightRed);
    }
    
    protected void addCritMissMessage(Player other) {
        other.addMessage("The kobold swings wildly.");
    }
    
    protected void addMissMessage(Player other) {
        other.addMessage("The kobold barely misses you.", Color.WHITE);
    }
    
    protected void addHitMessage(Player other) {
        other.addMessage("The kobold hits you.", AsciiPanel.red);
    }
}
