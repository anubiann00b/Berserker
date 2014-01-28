package game.item;

public class GroundedItem {
    private Item item;
    private int x;
    private int y;
    
    public GroundedItem(Item item, int x, int y) {
        this.item = item;
        this.x = x;
        this.y = y;
    }
    
    public GroundedItem(Item item) {
        this.item = item;
    }
    
    public Item getItem() { return this.item; }
    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
}
