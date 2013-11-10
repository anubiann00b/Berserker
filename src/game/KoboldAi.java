package game;

public class KoboldAi extends CreatureAi {
    private Creature player;
    
    KoboldAi(Creature creature, Creature player) {
        super(creature);
        this.player = player;
    }
    
    public void update() {
        if (creature.canSee(player.getX(), player.getY()))
            hunt();
        else
            wander();
    }

    private void hunt() {
        int offsetX = creature.getX()-player.getX();
        int offsetY = creature.getY()-player.getY();
        
        if (offsetX>0) {
            creature.moveBy(1,0);
        } else {
            creature.moveBy(-1,0);
        }
        if (offsetY>0) {
            creature.moveBy(0,1);
        } else {
            creature.moveBy(0,-1);
        }
    }
}
