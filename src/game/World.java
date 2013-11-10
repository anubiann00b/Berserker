package game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
 
public class World {
    private Tile[][] tiles;
    private ArrayList<GroundedItem> items;
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
        items = new ArrayList();
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
    
    public GroundedItem getItem(int x, int y){
        for (GroundedItem i : items){
            if (i.getX() == x && i.getY() == y)
                return i;
        }
        return null;
    }
    
    public void remove(Creature creature) {
        creatures.remove(creature);
    }
    
    public void remove(GroundedItem item) {
        items.remove(item);
    }
    
    public void update() {
        List<Creature> toUpdate = new ArrayList<Creature>(creatures);
        for (Creature creature : toUpdate){
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

    public void addAtEmptyLocation(GroundedItem item) {
        int x;
        int y;

        do {
            x = (int)(Math.random() * width);
            y = (int)(Math.random() * height);
        }
        while (!tile(x,y).isGround());

        item.setX(x);
        item.setY(y);
        items.add(item);
    }
}