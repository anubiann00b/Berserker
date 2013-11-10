package game;

import java.awt.Color;
import java.util.ArrayList;

public class Creature {
    private int x;
    private int y;
    private int maxHp;
    private int currentHp;
    private int maxRp;
    private int currentRp;
    private int atk;
    private int dmg;
    private int eva;
    private int def;
    private char glyph;
    private String name;
    private World world;
    private Color color;
    private CreatureAi ai;
    private int visionRadius;
    private boolean isEvil = true;
    protected ArrayList<String> messages = new ArrayList();
    //protected ArrayList<Item> inventory = new ArrayList();
    private Item weapon;
    private Item shield;
    private Item armor;

    protected ArrayList<Status> statuses = new ArrayList();

    Creature(String name, World world, char glyph, Color color, int maxHp, int maxRp, int baseStats) {
        this.name = name;
        this.world = world;
        this.glyph = glyph;
        this.color = color;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.maxRp = maxRp;
        this.currentRp = 0;
        this.visionRadius = 9;
        atk = baseStats;
        dmg = baseStats;
        eva = baseStats;
        def = baseStats;
        isEvil = true;
    }
    Creature(String name, World world, char glyph, Color color, int maxHp, int maxRp, int baseStats, boolean isEvil) {
        this.name = name;
        this.world = world;
        this.glyph = glyph;
        this.color = color;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.maxRp = maxRp;
        this.currentRp = 0;
        this.visionRadius = 9;
        this.isEvil = isEvil;
        atk = baseStats;
        dmg = baseStats;
        eva = baseStats;
        def = baseStats;
    }
    
    public void moveBy(int mx, int my) {
        Creature other = world.getCreature(x+mx, y+my);
        GroundedItem item = world.getItem(x+mx, y+my);
        if (other == null) {
            ai.onEnter(x+mx, y+my, world.tile(x+mx, y+my));
            setRp(-1);
        } else if (other.isEvil() != this.isEvil) {
            attack(other);
        } else {
            
        }
        if (item != null) {
            addMessage("You find a " + item.getItem().getType().getName() + ".");
        }
    }
    
    public boolean isEvil() { return this.isEvil; }
    public boolean canSee(int wx, int wy) { return ai.canSee(wx, wy); }
    public Tile getTile(int x, int y) { return world.tile(x, y); }
    public Creature getCreature(int x, int y) { return world.getCreature(x, y); }
    private String getName() { return this.name; }
    public int getVisionRadius() { return visionRadius; }
    public Color getColor() { return color; }
    public char getGlyph() { return glyph; }
    public int getCurrentHp() { return this.currentHp; }    
    public int getMaxHp() { return this.maxHp; }    
    public int getCurrentRp() { return this.currentRp; }    
    public int getMaxRp() { return this.maxRp; }  
    public int getX() { return this.x; }    
    public int getY() { return this.y; }
    public int getAtk() { return this.atk; }    
    public int getDmg() { return this.dmg; }    
    public int getEva() { return this.eva; }   
    public int getDef() { return this.def; }
    public void setAtk(int atk) { this.atk += atk; }    
    public void setDmg(int dmg) { this.dmg += dmg; }
    public void setEva(int eva) { this.eva += eva; }    
    public void setDef(int def) { this.def += def; }
    public void setCreatureAi(CreatureAi ai) { this.ai = ai; }
        
    public void setX(int x) { this.x = x; }    
    public void setY(int y) { this.y = y; }
    public void setHp(int health) {
        this.currentHp += health;
        if(currentHp<0)
            currentHp=0;
        if(currentHp>maxHp)
            currentHp=maxHp;
    }
    
    public void setRp(int rage) {
        if(currentRp+rage>=0 && currentRp+rage<=maxRp) {
            this.currentRp += rage;
            setAtk(rage);
            setDmg(rage);
        }
    }

    public ArrayList<String> getMessages() {
        return ai.getMessages();
    }
    
    public void addMessage(String message) {
        messages.add(message);
    }

    private void attack(Creature other) {
        //To hit (value between 0 and 99)
        int atkRoll = (int) Math.floor(Math.random()*20) + 1;
        int dmgRoll = (int) Math.floor(Math.random()*5) + 1;
        if (atkRoll >= 20) {
            addMessage("CRITICAL HIT!");
            other.setHp(-(dmg-other.def+5)*2);
            setRp(2);
        } else if (atkRoll <= 1) {
            addMessage("You critically miss. Gj.");
            setRp(-1);
        } else if (atkRoll <= 10-(atk-other.eva)) {
            addMessage("Aww, you miss. What a shame.");
        } else {
            addMessage("You strike the " + other.getName() + ".");
            other.setHp(-(dmg-other.def+dmgRoll));
            setRp(1);
        }
        if (other.getCurrentHp()<1) {
            world.remove(other);
            addMessage("You vanquish the " + other.getName() + "!");
            setRp(1);
        }
    }

    public void update() {
        ai.update();
    }
}