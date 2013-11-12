package game;

import java.util.ArrayList;

public class CreatureAi {
    protected Creature creature;
 
    public CreatureAi(Creature creature){
        this.creature = creature;
        this.creature.setCreatureAi(this);
    }
 
    public void onEnter(int x, int y, Tile tile) { }
    
    public boolean canSee(int wx, int wy) {
        if ((creature.getX()-wx)*(creature.getX()-wx) + (creature.getY()-wy)*(creature.getY()-wy) > creature.getVisionRadius()*creature.getVisionRadius())
            return false;
     
        for (Point p : new Line(creature.getX(), creature.getY(), wx, wy)) {
            if (creature.getTile(p.x, p.y).isPassable() || p.x == wx && p.y == wy)
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
        while(other != null && other.isEvil() == true) {
            mx = (int) (Math.random()*3)-1;
            my = (int) (Math.random()*3)-1;
            other = creature.getCreature(creature.getX()+mx,creature.getY()+my);
        }
        creature.moveBy(mx, my);
    }

    protected void update() {
    }
}