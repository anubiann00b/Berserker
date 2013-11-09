package game;

public class WorldBuilder {
    private int width;
    private int height;
    private Tile[][] tiles;
 
    public WorldBuilder(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width][height];
    }
    
    private WorldBuilder cellularAutomata(double chanceOfFloor, int times, int liveAmount) {
        Tile[][] tiles2 = new Tile[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles2[x][y] = Math.random() < chanceOfFloor ? Tile.FLOOR : Tile.WALL;
            }
        }
        for (int time = 0; time < times; time++) {
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                int floorCount = 0;
                int wallCount = 0;

                for (int ox = -1; ox <= 1; ox++) {
                    for (int oy = -1; oy <= 1; oy++) {
                    if (x + ox < 0 || x + ox >= width || y + oy < 0 || y + oy >= height)
                        continue;
                        if (tiles[x + ox][y + oy] == Tile.FLOOR)
                            floorCount++;
                        else
                            wallCount++;
                        }
                    }
                    if (wallCount >= liveAmount) {
                        tiles2[x][y] = Tile.WALL;
                    } else if (wallCount == 0) {
                        tiles2[x][y] = Tile.WALL;
                    } else {    
                        tiles2[x][y] = Tile.FLOOR;
                    }
                    tiles2[x][y] = floorCount >= wallCount ? Tile.FLOOR : Tile.WALL;
                }
            }
            tiles = tiles2;
        }
        return this;
    }
    
    public WorldBuilder generateWorld() {
        return cellularAutomata(0.55,5,5);
    }
    
    public World create() {
        return new World(tiles);
    }
}
