package game;

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
}
