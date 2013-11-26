package game;

import asciiPanel.AsciiPanel;
import java.awt.Color;

public class KoboldAi extends CreatureAi {
    private Creature player;
    
    KoboldAi(Creature creature, Creature player) {
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
        if (creature.canSee(player.getX(), player.getY()))
            hunt();
        else
            wander();
    }

    private void hunt() {
        int ox = creature.getX()-player.getX();
        int oy = creature.getY()-player.getY();
        if (ox>0) {
            creature.moveBy(-1,0);
        } else if (ox<0) {
            creature.moveBy(1,0);
        }
        if (oy>0) {
            creature.moveBy(0,-1);
        } else if (oy<0) {
            creature.moveBy(0,1);
        }
    }
    
    protected void addCritMessage(Creature other) {
        other.addMessage("The kobold pulls off a devasting attack!",AsciiPanel.brightRed);
        /*
        double r = Math.random();
        if (r<0.2)
            other.addMessage("The kobold's weapon tears through your flesh!", AsciiPanel.brightRed);
        else if (r<0.4)
            other.addMessage("The kobold skewers you!",AsciiPanel.brightRed);
        else if (r<0.6)
            other.addMessage("The kobold pulls off a devasting attack!",AsciiPanel.brightRed);
        else if (r<0.8)
            other.addMessage("The kobold really hurts you.",AsciiPanel.brightRed);
        else if (r<1)
            other.addMessage("YOU IMPALE THE LITTLE INSECT",AsciiPanel.brightRed);
        */
    }
    
    protected void addCritMissMessage(Creature other) {
        other.addMessage("The kobold swings wildly.");
        /*
        double r = Math.random();
        if (r<0.2)
            other.addMessage("You are very MISS-leading in your combat ability.");
        else if (r<0.4)
            other.addMessage("Even a baby could of hit that.");
        else if (r<0.6)
            other.addMessage("You get an A for effort.");
        else if (r<0.8)
            other.addMessage("Who taught you to fight, your grandpa?");
        else if (r<1)
            other.addMessage("YOU SHAME YOUR FAMILY");
        */
    }
    
    protected void addMissMessage(Creature other) {
        other.addMessage("The kobold barely misses you.", Color.WHITE);
        /*
        double r = Math.random();
        if (r<0.2)
            other.addMessage("Your weapon barely grazes it. Try harder.", Color.WHITE);
        else if (r<0.4)
            other.addMessage("You miss.", Color.WHITE);
        else if (r<0.6)
            other.addMessage("You missed. Better luck next time!", Color.WHITE);
        else if (r<0.8)
            other.addMessage("Maybe you should train harder.", Color.WHITE);
        else if (r<1)
            other.addMessage("You must study more.", Color.WHITE);
        */
    }
    
    protected void addHitMessage(Creature other) {
        other.addMessage("The kobold hits you.", AsciiPanel.red);
        /*
        double r = Math.random();
        if (r<0.2)
            other.addMessage("You hit the " + other.getName() + ".", AsciiPanel.red);
        else if (r<0.4)
            other.addMessage("You strike the " + other.getName() + ".", AsciiPanel.red);
        else if (r<0.6)
            other.addMessage("You swing at the " + other.getName() + ".", AsciiPanel.red);
        else if (r<0.8)
            other.addMessage("You smack the " + other.getName() + ".", AsciiPanel.red);
        else if (r<1)
            other.addMessage("You clobber the " + other.getName() + ".", AsciiPanel.red);
        */
    }
}
