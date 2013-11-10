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
            creature.addMessage("You can't move there!");
        }
    }
    
    public ArrayList<String> getMessages() {
        ArrayList<String> theMessages = new ArrayList();
        theMessages.addAll(creature.messages);
        creature.messages.clear();
        return theMessages;
    }
}