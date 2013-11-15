package game;

import asciiPanel.AsciiPanel;
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
    private final char glyph;
    private final String name;
    private final Color color;
    private World world;
    private CreatureAi ai;
    private int visionRadius;
    private boolean isEvil = true;
    private Item weapon;
    private Item shield;
    private Item armor;
    protected ArrayList<Message> messages = new ArrayList();
    protected ArrayList<Status> statuses = new ArrayList();
    private ArrayList<Message> m = new ArrayList();
    
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
        this.weapon = new Item(Equipable.STICK, 0);
        this.armor = new Item(Equipable.SHIRT, 0);
        this.shield = new Item(Equipable.LONGSLEEVES, 0);
    }
    
    public int getX() { return this.x; }    
    public int getY() { return this.y; }
    public int getCurrentHp() { return this.currentHp; }    
    public int getMaxHp() { return this.maxHp; }    
    public int getCurrentRp() { return this.currentRp; }    
    public int getMaxRp() { return this.maxRp; }
    public int getAtk() { return this.atk; }    
    public int getDmg() { return this.dmg; }    
    public int getEva() { return this.eva; }   
    public int getDef() { return this.def; }
    public int getVisionRadius() { return visionRadius; }
    public char getGlyph() { return glyph; }
    public String getName() { return this.name; }
    public Color getColor() { return color; }
    public Item getWeapon() { return this.weapon; }
    public Item getShield() { return this.shield; }
    public Item getArmor() { return this.armor; }
    public boolean isEvil() { return this.isEvil; }
    public ArrayList<Message> getMessages() { return ai.getMessages(); }

    public Tile getTile(int x, int y) { return world.tile(x, y); }
    public Creature getCreature(int x, int y) { return world.getCreature(x, y); }

    public void setX(int x) { this.x = x; }    
    public void setY(int y) { this.y = y; }
    public void setAtk(int atk) { this.atk += atk; }    
    public void setDmg(int dmg) { this.dmg += dmg; }
    public void setEva(int eva) { this.eva += eva; }    
    public void setDef(int def) { this.def += def; }
    public void setHp(int health) { this.currentHp = Math.max(0,Math.min(currentHp+health,maxHp)); }
    public void setRp(int rage) { if(currentRp+rage>=0 && currentRp+rage<=maxRp) {this.currentRp += rage; setAtk(rage); setDmg(rage);} }
    public void setCreatureAi(CreatureAi ai) { this.ai = ai; }

    public void addMessage(Message message) { messages.add(message); }
    public void addMessage(String message) { messages.add(new Message(message)); }
    public void addMessage(String message, Color color) { messages.add(new Message(message,color)); }
    
    public void update() { ai.update(); }
    public void dealDamage(int damage) { setHp(Math.min(-damage,-1)); }
    public boolean canSee(int wx, int wy) { return ai.canSee(wx, wy); }
    
    public void pickUp() {
        GroundedItem item = world.getItem(x, y);
        GroundedItem newItemDropped = null;
        if (item == null) {
            addMessage("You sucessfully pick up nothing!", Color.ORANGE);
        } else {
            this.atk -= this.weapon.getAtk();
            this.dmg -= this.weapon.getDmg();
            this.eva -= this.weapon.getEva();
            this.def -= this.weapon.getDef();
            this.def -= this.armor.getDef();
            this.eva -= this.armor.getEva();
            this.def -= this.shield.getDef();
            this.eva -= this.shield.getEva();
            if (item.getItem().getEquipable().getType() == 0) {
                addMessage(this.weapon.getName() + " dropped.", AsciiPanel.green);
                newItemDropped = new GroundedItem(this.weapon, x, y);
                this.weapon = item.getItem();
            } else if (item.getItem().getEquipable().getType() == 1) {
                addMessage(this.armor.getName() + " dropped.", AsciiPanel.green);
                newItemDropped = new GroundedItem(this.armor, x, y);
                this.armor = item.getItem();
            } else if (item.getItem().getEquipable().getType() == 2) {
                addMessage(this.shield.getName() + " dropped.", AsciiPanel.green);
                newItemDropped = new GroundedItem(this.shield, x, y);
                this.shield = item.getItem();
            }
            this.atk += this.weapon.getAtk();
            this.dmg += this.weapon.getDmg();
            this.eva += this.weapon.getEva();
            this.def += this.weapon.getDef();
            this.def += this.armor.getDef();
            this.eva += this.armor.getEva();
            this.def += this.shield.getDef();
            this.eva += this.shield.getEva();
            world.remove(item);
            addMessage(item.getItem().getName() + " equipped.", AsciiPanel.green);
            world.setItem(newItemDropped);
        }
    }
    
    public void moveBy(int mx, int my) {
        Creature other = world.getCreature(x+mx, y+my);
        GroundedItem item = world.getItem(x+mx, y+my);
        if (other == null) {
            ai.onEnter(x+mx, y+my, world.tile(x+mx, y+my));
            setRp(-1);
        } else if (other.isEvil() != this.isEvil) {
            attack(other);
        }
        if (item != null) {
            addMessage("You find a " + item.getItem().getName() + ".", Color.WHITE);
        }
    }

    private void attack(Creature other) {
        int atkRoll = (int) Math.floor(Math.random()*20) + 1;
        int dmgRoll = (int) Math.floor(Math.random()*5) + 1;
        if (atkRoll >= 20) {
            ai.addCritMessage(other);
            other.dealDamage((dmg+5)*2-other.def);
            setRp(3);
        } else if (atkRoll <= 1) {
            ai.addCritMissMessage(other);
            setRp(-1);
        } else if (atkRoll <= 10-(atk-other.eva)) {
            ai.addMissMessage(other);
        } else {
            ai.addHitMessage(other);
            other.dealDamage(dmg-other.def+dmgRoll);
            setRp(1);
        }
        if (other.getCurrentHp()<1) {
            world.remove(other);
            addMessage("The " + other.getName() + " dies!", AsciiPanel.brightGreen);
            setRp(1);
            setHp(1);
        }
    }
    
    protected void getMessageList(ArrayList<Message> m) {
        this.m.addAll(m);
    }
}