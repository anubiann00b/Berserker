package game.world;

import java.util.Arrays;

public class WorldBuilder {
    private int width;
    private int height;
    private Tile[][] tiles;
 
    public WorldBuilder(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width][height];
    }
 
    public World build() {
        return new World(tiles);
    }
    
    private WorldBuilder randomizeTiles(double chanceOfFloor) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = Math.random() < chanceOfFloor ? Tile.FLOOR : Tile.WALL;
            }
        }
        return this;
    }
    
    private WorldBuilder smooth(int times, int liveAmount) {
        Tile[][] tiles2 = new Tile[width][height];
        for (int time = 0; time < times; time++) {
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                int floors = 0;
                int walls = 0;

                for (int ox = -1; ox < 2; ox++) {
                    for (int oy = -1; oy < 2; oy++) {
                    if (x + ox < 0 || x + ox >= width || y + oy < 0 || y + oy >= height)
                        continue;
                    if (tiles[x + ox][y + oy] == Tile.FLOOR)
                        floors++;
                    else
                        walls++;
                    }
                }
                if (walls >= liveAmount) {
                    tiles2[x][y] = Tile.WALL;
                } else if (walls == 0) {
                    tiles2[x][y] = Tile.WALL;
                } else {
                    tiles2[x][y] = Tile.FLOOR;
                }
                tiles2[x][y] = floors >= walls ? Tile.FLOOR : Tile.WALL;
                }
            }
            tiles = Arrays.copyOf(tiles2, tiles2.length);
        }
        tiles = Arrays.copyOf(tiles2, tiles2.length);
        return this;
    }

    public WorldBuilder makeCaves() {
        return randomizeTiles(0.55).smooth(5,5);
    }
}