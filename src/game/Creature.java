package game;

import java.awt.Color;
import java.util.ArrayList;

public class Creature {
    private int x;
    private int y;
    private int maxHp;
    private int currentHp;
    private int maxMp;
    private int currentMp;
    private int atk;
    private int dmg;
    private int eva;
    private int def;
    private char glyph;
    private World world;
    private Color color;
    private CreatureAi ai;
    private int visionRadius;
    protected ArrayList<String> messages = new ArrayList();
    //protected ArrayList<Items> inventory = new ArrayList();

    Creature(World world, char glyph, Color color, int maxHp, int maxMp) {
        this.world=world;
        this.glyph=glyph;
        this.color=color;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.maxMp = maxMp;
        this.currentMp = maxMp;
        this.visionRadius = 9;
    }
    
    public void moveBy(int mx, int my) {
        ai.onEnter(x+mx, y+my, world.tile(x+mx, y+my));
    }
     
    public boolean canSee(int wx, int wy){
        return ai.canSee(wx, wy);
    }
 
    public Tile tile(int x, int y) {
        return world.tile(x, y);
    }
    
    public int getVisionRadius() { return visionRadius; }
    public Color getColor() { return color; }
    public char getGlyph() { return glyph; }
    public int getCurrentHp() { return this.currentHp; }    
    public int getMaxHp() { return this.maxHp; }    
    public int getCurrentMp() { return this.currentMp; }    
    public int getMaxMp() { return this.maxMp; }  
    public int getX() { return this.x; }    
    public int getY() { return this.y; }
      
    public int getAtk() { return this.atk; }    
    public int getDmg() { return this.dmg; }    
    public int getEva() { return this.eva; }   
    public int getDef() { return this.def; }
    public void setCreatureAi(CreatureAi ai) { this.ai = ai; }
        
    public void setX(int x) { this.x = x; }    
    public void setY(int y) { this.y = y; }
    public void setHp(int health) { this.currentHp += health; if(currentHp<0) currentHp=0; if(currentHp>maxHp) currentHp=maxHp; }
    public void setMp(int mana) { this.currentMp += mana; if(currentMp<0) currentMp=0; if(currentMp>maxMp) currentMp=maxMp; }

    public ArrayList<String> getMessages() {
        return ai.getMessages();
    }
    
    public void addMessage(String message) {
        messages.add(message);
    }
}