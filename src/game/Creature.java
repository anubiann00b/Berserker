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
    private int statStr;
    private int statDex;
    private int statInt;
    private int statCon;
    private int attack;
    private int damage;
    private int defense;
    private int evasion;
    private int deflect;
    private int parry;
    private int block;
    private char glyph;
    private World world;
    private Color color;
    private CreatureAi ai;
    private int visionRadius;
    protected ArrayList<String> messages = new ArrayList();
    
    public Creature(World world, char glyph, Color color) {
        this.world = world;
        this.glyph = glyph;
        this.color = color;
        this.visionRadius = 9;
    }
    
    public Creature(World world, char glyph, Color color, int maxHp) {
        this.world = world;
        this.glyph = glyph;
        this.color = color;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.visionRadius = 9;
    }
    
    public Creature(World world, char glyph, Color color, int maxHp, int maxMp) {
        this.world = world;
        this.glyph = glyph;
        this.color = color;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.maxMp = maxMp;
        this.currentMp = maxMp;
        this.visionRadius = 9;
    }    
    
    public Creature(World world, char glyph, Color color, int statStr, int statDex, int statInt, int statCon) {
        this.world = world;
        this.glyph = glyph;
        this.color = color;
        this.maxHp = statCon+10;
        this.currentHp = this.maxHp;
        this.maxMp = statInt+2;
        this.currentMp = this.maxMp;
        this.statStr = statStr;
        this.statDex = statDex;
        this.statInt = statInt;
        this.statCon = statCon;
        this.attack = statStr/3 + statDex;
        this.damage = statStr + statDex/5;
        this.evasion = statDex+2;
        this.block = statStr/2 + statCon/2;
        this.deflect = statStr/5 + statDex;
        this.parry = statDex;
        this.visionRadius = 9;
        this.addMessage("You have spawned!");
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
    
    public int getStr() { return this.statStr; }    
    public int getDex() { return this.statDex; }    
    public int getInt() { return this.statInt; }    
    public int getCon() { return this.statCon; }    
    public int getAttack() { return this.attack; }    
    public int getDamage() { return this.damage; }    
    public int getEvasion() { return this.evasion; }
    public int getBlock() { return this.block; }    
    public int getDeflect() { return this.deflect; }    
    public int getParry() { return this.parry; }    


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