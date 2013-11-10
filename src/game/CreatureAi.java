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
            if (creature.tile(p.x, p.y).isPassable() || p.x == wx && p.y == wy)
                continue;
            return false;
        }
     
        return true;
    }

    public ArrayList<String> getMessages() {
        return null;
    }

    protected void update() {
    }
}