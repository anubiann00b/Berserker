package game.player;

import game.util.Line;
import game.util.Point;
import game.world.Tile;
import game.world.World;

public class FieldOfView {
    
    private World world;
    private boolean[][] visible;
    
    public boolean isVisible(int x, int y) {
        return x >= 0 && y >= 0 && x < visible.length && y < visible[0].length && visible[x][y];
    }
 
    private Tile[][] tiles;
    public Tile tile(int x, int y) {
        return tiles[x][y];
    }
 
    public FieldOfView(World world) {
        this.world = world;
        this.visible = new boolean[world.getWidth()][world.getHeight()];
        this.tiles = new Tile[world.getWidth()][world.getHeight()];
        
        blankFOV();
    }
    
    public void blankFOV() {
        for (int x = 0; x < world.getWidth(); x++) {
            for (int y = 0; y < world.getHeight(); y++) {
                tiles[x][y] = Tile.UNKNOWN;
            }
        }
    }
    
    public void update(int wx, int wy, int r) {
        visible = new boolean[world.getWidth()][world.getHeight()];
     
        for (int x = -r; x <= r; x++) {
            for (int y = -r; y <= r; y++) {
                if (x*x + y*y >= r*r)
                    continue;
          
                if (wx + x < 0 || wx + x >= world.getWidth() || wy + y < 0 || wy + y >= world.getHeight())
                    continue;
          
                for (Point p : new Line(wx, wy, wx + x, wy + y)) {
                    Tile tile = world.tile(p.getX(), p.getY());
                    visible[p.getX()][p.getY()] = true;
                    tiles[p.getX()][p.getY()] = tile;
              
                    if (!tile.isTransparent())
                        break;
                }
            }
        }
    }
}