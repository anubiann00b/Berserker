package game;

public class World {
    private int height;
    private int width;
    private Tile[][] tiles;
    
    public int getWidth() { return this.width; }
    public int getHeight() { return this.height; }
    
    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }
    
    public World(Tile[][] tiles) {
        this.height = tiles.length;
        this.width = tiles[0].length;
        this.tiles = tiles;
    }
}
