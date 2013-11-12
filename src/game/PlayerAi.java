package game;

import game.screens.*;
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
}