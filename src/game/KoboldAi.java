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
        int ox = Math.abs(creature.getX()-player.getX());
        int oy = Math.abs(creature.getY()-player.getY());
        int lowest = Math.max(ox,oy)-1;
        int[][] area = new int[3][3];
        area[1][1] = Math.max(ox,oy);
        for(int ry=-1;ry<=1;ry++) {
            for(int rx=-1;rx<=1;rx++) {
                ox = Math.abs(creature.getX()-player.getX());
                oy = Math.abs(creature.getY()-player.getY());
                area[1+rx][1+ry] = Math.max(ox,oy);
            }
        }
        String area1 = area[0][0] + " " + area[0][1] + " " + area[0][2];
        String area2 = area[1][0] + " " + area[1][1] + " " + area[1][2];
        String area3 = area[2][0] + " " + area[2][1] + " " + area[2][2];
        System.out.println(area1);
        System.out.println(area2);
        System.out.println(area3);
        System.out.println();
        int xIndex = (int) Math.random()*3;
        int yIndex = (int) Math.random()*3;
        do {
            xIndex = (int) Math.random()*3;
            yIndex = (int) Math.random()*3;
        } while (area[xIndex][yIndex] < lowest);
        creature.moveBy(xIndex-1,yIndex-1);
        /*
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
        */
    }
}
