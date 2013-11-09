package game;

public class Creature {
    private int x;
    private int y;
    private int currentHp;
    private int totalHp;
    private int currentMp;
    private int totalMp;
    private int attack;
    private int damage;
    private int evasion;
    private int armor;
    
    public Creature(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public int getX() { return x; }    
    public int getY() { return y; }
    public void setHp(int hp) { currentHp+=hp; }
    public void setMp(int mp) { currentMp+=mp; }
    
    public void moveBy(int x, int y) {
        this.x+=x;
        this.y+=y;
    }
}
