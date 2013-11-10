package game;

import java.util.Random;
import java.lang.Math;

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
                int rocks = 0;

                for (int ox = -1; ox < 2; ox++) {
                    for (int oy = -1; oy < 2; oy++) {
                    if (x + ox < 0 || x + ox >= width || y + oy < 0 || y + oy >= height)
                        continue;
                        if (tiles[x + ox][y + oy] == Tile.FLOOR)
                            floors++;
                        else
                            rocks++;
                        }
                    }
                    if (rocks >= liveAmount) {
                        tiles2[x][y] = Tile.WALL;
                    } else if (rocks == 0) {
                        tiles2[x][y] = Tile.WALL;
                    } else {    
                        tiles2[x][y] = Tile.FLOOR;
                    }
                    tiles2[x][y] = floors >= rocks ? Tile.FLOOR : Tile.WALL;
                }
            }
            tiles = tiles2;
        }
        return this;
    }
    
    private WorldBuilder border() {
        Tile[][] tiles2 = tiles;
        
        for (int y=0;y<tiles2[0].length;y++) {
            tiles2[0][y] = Tile.WALL;
        }
        
        for (int y=0;y<tiles2[0].length;y++) {
            tiles2[tiles2.length-1][y] = Tile.WALL;
        }
        
        for (int x=0;x<tiles2.length;x++) {
            tiles2[x][0] = Tile.WALL;
        }
        
        for (int x=0;x<tiles2.length;x++) {
            tiles2[x][tiles2[0].length-1] = Tile.WALL;
        }
        tiles = tiles2;
        return this;
    }
    
    private WorldBuilder drunkardWalk(int paths, int steps) {
        Random r = new Random();
        
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = Tile.WALL;
            }
        }
        
        int cursorX = 45;//r.nextInt(width);
        int cursorY = 16;//r.nextInt(height);
        int direction;
        int length;
        
        tiles[cursorX][cursorY] = Tile.FLOOR;
        
        for (int i=0;i<paths;i++) {
            direction = r.nextInt(4); // right 0, up 1, left 2, down 3
            
            length = steps;
            if (direction == 0) {
                for (int j=0; j<length; j++) {
                    if (cursorX>0 && cursorX<width-1) {
                        cursorX++;
                        tiles[cursorX][cursorY] = Tile.FLOOR;
                    } else {
                        i--;
                        break;
                    }
                }
            }
            if (direction == 1) {
                for (int j=0; j<length; j++) {
                    if (cursorY>0 && cursorY<height-1) {
                        cursorY++;
                        tiles[cursorX][cursorY] = Tile.FLOOR;
                    } else {
                        i--;
                        break;
                    }
                }
            }
            if (direction == 2) {
                for (int j=0; j<length; j++) {
                    if (cursorX>0 && cursorX<width-1) {
                        cursorX--;
                        tiles[cursorX][cursorY] = Tile.FLOOR;
                    } else {
                        i--;
                        break;
                    }
                }
            }
            if (direction == 3) {
                for (int j=0; j<length; j++) {
                    if (cursorY>0 && cursorY<height-1) {
                        cursorY--;
                        tiles[cursorX][cursorY] = Tile.FLOOR;
                    } else {
                        i--;
                        break;
                    }
                }
            }
        }
        
        return this;
    }
    
    public WorldBuilder makeCaves() {
        return randomizeTiles(0.55).smooth(5,5);
        //return drunkardWalk(15, 10);
    }
}