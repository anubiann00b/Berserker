package game;

import java.awt.Color;

public class Creature {
    private int x;
    private int y;
    private char character;
    private Color color;
    private int currentHp;
    private int totalHp;
    private int currentMp;
    private int totalMp;
    private int attack;
    private int damage;
    private int evasion;
    private int armor;
    
    public Creature(int x, int y, char character, Color color)
    {
        this.x = x;
        this.y = y;
        this.character = character;
        this.color = color;
    }
    
    public int getX() { return this.x; }    
    public int getY() { return this.y; }
    public char getChar() { return this.character; }
    public Color getColor() { return this.color; }
    public void setHp(int hp) { currentHp+=hp; }
    public void setMp(int mp) { currentMp+=mp; }
    
    public void moveBy(int x, int y) {
        this.x+=x;
        this.y+=y;
    }
}
