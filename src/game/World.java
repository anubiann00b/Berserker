package game;

import java.awt.Color;
import java.util.ArrayList;
 
public class World {
    private Tile[][] tiles;
    //private ArrayList<Equipable> equipable;
    //private ArrayList<Wearable> wearable;
    private ArrayList<ArrayList> items;
    private ArrayList<Creature> creatures;
    
    private int width;
    public int width() { return width; }
 
    private int height;
    public int height() { return height; }
 
    public World(Tile[][] tiles){
        this.tiles = tiles;
        this.width = tiles.length;
        this.height = tiles[0].length;
        creatures = new ArrayList();
    }
    
    public Tile tile(int x, int y){
        if (x < 0 || x >= width || y < 0 || y >= height)
            return Tile.BOUNDS;
        else
            return tiles[x][y];
    }
    
    public char getGlyph(int x, int y) {
        return tile(x, y).glyph();
    }
    
    public Color getColor(int x, int y) {
        return tile(x, y).color();
    }
    
    public Creature getCreature(int x, int y){
        for (Creature c : creatures){
            if (c.getX() == x && c.getY() == y)
                return c;
        }
        return null;
    }
    
    public void remove(Creature creature) {
        creatures.remove(creature);
    }

    public void update(){
        for (Creature creature : creatures){
            creature.update();
    }
}
    public void addAtEmptyLocation(Creature creature) {
        int x;
        int y;

        do {
            x = (int)(Math.random() * width);
            y = (int)(Math.random() * height);
        }
        while (!tile(x,y).isGround());

        creature.setX(x);
        creature.setY(y);
        creatures.add(creature);
    }
}