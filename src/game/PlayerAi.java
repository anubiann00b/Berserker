package game;

import asciiPanel.AsciiPanel;
import java.awt.Color;
import java.util.ArrayList;

public class PlayerAi extends CreatureAi {
    private FieldOfView fov;

    public PlayerAi(Creature creature, FieldOfView fov) {
        super(creature);
        this.fov = fov;
    }
    
    public boolean canSee(int wx, int wy) {
        return fov.isVisible(wx, wy);
    }
    
    public void onEnter(int x, int y, Tile tile){
        if (tile.isPassable()) {
            creature.setX(x);
            creature.setY(y);
        } else {
            double r = Math.random();
            if (r<0.2) {
                creature.addMessage("Good luck trying to walk through walls.");
            } else if (r<0.4) {
                creature.addMessage("You can't move there.");
            } else if (r<0.6) {
                creature.addMessage("You crash into a stone wall.");
            } else if (r<0.8) {
                creature.addMessage("Ow.");
            } else if (r<1) {
                creature.addMessage("The wall mutters some questionable adjectives.");
            }
        }
    }
    
    public ArrayList<Message> getMessages() {
        ArrayList<Message> theMessages = new ArrayList();
        theMessages.addAll(creature.messages);
        creature.messages.clear();
        return theMessages;
    }
    
    protected void addCritMessage(Creature other) {
        double r = Math.random();
        if (r<0.2)
            creature.addMessage("Your weapon bestows your rage upon your victims!", AsciiPanel.brightRed);
        else if (r<0.4)
            creature.addMessage("You skewer the pathetic creature!",AsciiPanel.brightRed);
        else if (r<0.6)
            creature.addMessage("You pull off a devasting attack!",AsciiPanel.brightRed);
        else if (r<0.8)
            creature.addMessage("Your grandpa's secret technique passsed on through the generations hits!",AsciiPanel.brightRed);
        else if (r<1)
            creature.addMessage("YOU IMPALE THE LITTLE INSECT",AsciiPanel.brightRed);
    }
    
    protected void addCritMissMessage(Creature other) {
        double r = Math.random();
        if (r<0.2)
            creature.addMessage("You are very MISS-leading in your combat ability.");
        else if (r<0.4)
            creature.addMessage("Even a baby could of hit that.");
        else if (r<0.6)
            creature.addMessage("You get an A for effort.");
        else if (r<0.8)
            creature.addMessage("Who taught you to fight, your grandpa?");
        else if (r<1)
            creature.addMessage("YOU SHAME YOUR FAMILY");
    }
    
    protected void addMissMessage(Creature other) {
        double r = Math.random();
        if (r<0.2)
            creature.addMessage("Your weapon barely grazes it. Try harder.", Color.WHITE);
        else if (r<0.4)
            creature.addMessage("You miss.", Color.WHITE);
        else if (r<0.6)
            creature.addMessage("You missed. Better luck next time!", Color.WHITE);
        else if (r<0.8)
            creature.addMessage("Maybe you should train harder.", Color.WHITE);
        else if (r<1)
            creature.addMessage("You must study more.", Color.WHITE);
    }
    
    protected void addHitMessage(Creature other) {
        double r = Math.random();
        if (r<0.2)
            creature.addMessage("You hit the " + other.getName() + ".", AsciiPanel.red);
        else if (r<0.4)
            creature.addMessage("You strike the " + other.getName() + ".", AsciiPanel.red);
        else if (r<0.6)
            creature.addMessage("You swing at the " + other.getName() + ".", AsciiPanel.red);
        else if (r<0.8)
            creature.addMessage("You smack the " + other.getName() + ".", AsciiPanel.red);
        else if (r<1)
            creature.addMessage("You clobber the " + other.getName() + ".", AsciiPanel.red);
    }
}