package game.enemy.ai;

import game.enemy.Creature;
import game.message.Message;
import game.player.Player;
import game.util.Line;
import game.util.Point;
import game.world.Tile;
import java.util.ArrayList;

public class CreatureAi {
    
    protected Creature creature;
    
    public CreatureAi(Creature creature) {
        this.creature = creature;
        this.creature.setCreatureAi(this);
    }
    
    public void onEnter(int x, int y, Tile tile) { }

    public boolean canSee(int wx, int wy) {
        if ((creature.getX()-wx)*(creature.getX()-wx) + (creature.getY()-wy)*(creature.getY()-wy) > creature.getVisionRadius()*creature.getVisionRadius())
            return false;
     
        for (Point p : new Line(creature.getX(), creature.getY(), wx, wy)) {
            if (creature.getTile(p.getX(), p.getY()).isPassable() || p.getX() == wx && p.getY() == wy)
                continue;
            return false;
        }
     
        return true;
    }

    public ArrayList<Message> getMessages() {
        return null;
    }
    
    public void wander() {
        int mx = (int) (Math.random()*3)-1;
        int my = (int) (Math.random()*3)-1;
        Creature other = creature.getCreature(creature.getX()+mx,creature.getY()+my);
        while(other != null) {
            mx = (int) (Math.random()*3)-1;
            my = (int) (Math.random()*3)-1;
            other = creature.getCreature(creature.getX()+mx,creature.getY()+my);
        }
        creature.moveBy(mx, my);
    }

    public void update() { }
    public void addCritMessage(Player other) { }
    public void addCritMissMessage(Player other) { }
    public void addMissMessage(Player other) { }
    public void addHitMessage(Player other) { }
}