package game;

public class FieldOfView {
    private World world;
    private int depth;
 
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
        this.visible = new boolean[world.width()][world.height()];
        this.tiles = new Tile[world.width()][world.height()];
        
        blankFOV();
    }
    
    public void blankFOV() {
        for (int x = 0; x < world.width(); x++) {
            for (int y = 0; y < world.height(); y++) {
                tiles[x][y] = Tile.UNKNOWN;
            }
        }
    }
    
    public void update(int wx, int wy, int r) {
        visible = new boolean[world.width()][world.height()];
     
        for (int x = -r; x <= r; x++) {
            for (int y = -r; y <= r; y++) {
                if (x*x + y*y >= r*r)
                    continue;
          
                if (wx + x < 0 || wx + x >= world.width() || wy + y < 0 || wy + y >= world.height())
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