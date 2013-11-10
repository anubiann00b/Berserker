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
    public Item getWeapon() { return this.weapon; }
    private Item shield;
    public Item getShield() { return this.shield; }
    private Item armor;
    public Item getArmor() { return this.armor; }

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
        this.weapon = new Item(Equipable.MAUL, 0);
        this.armor = new Item(Equipable.SHIRT, 0);
        this.shield = new Item(Equipable.LONGSLEEVES, 0);
    }
    
    
    public void pickUp()
    {
        GroundedItem item = world.getItem(x, y);
        if (item == null) {
            addMessage("You sucessfully pick up nothing!");
            return;
        }
        if (item.getItem().getType().getType() == 0) {
            this.atk -= this.weapon.getType().getAttack();
            this.dmg -= this.weapon.getType().getDamage();
            addMessage(this.weapon.getType().getName() + " dropped.");
            GroundedItem newItem = new GroundedItem(this.weapon, x, y);
            world.remove(item);
            this.weapon = item.getItem();
            addMessage(item.getItem().getType().getName() + " equipped.");
            this.atk += this.weapon.getType().getAttack();
            this.dmg += this.weapon.getType().getDamage();
            world.setItem(newItem);
        }
        else if (item.getItem().getType().getType() == 1) {
            this.def -= this.armor.getType().getDefense();
            this.eva -= this.armor.getType().getEvasion();
            addMessage(this.armor.getType().getName() + " dropped.");
            GroundedItem newItem = new GroundedItem(this.armor, x, y);
            world.remove(item);
            this.armor = item.getItem();
            addMessage(item.getItem().getType().getName() + " equipped.");
            this.def += this.armor.getType().getDefense();
            this.eva += this.armor.getType().getEvasion();
            world.setItem(newItem);
        }
        else if (item.getItem().getType().getType() == 2) {
            this.def -= this.shield.getType().getDefense();
            this.eva -= this.shield.getType().getEvasion();
            addMessage(this.shield.getType().getName() + " dropped.");
            GroundedItem newItem = new GroundedItem(this.shield, x, y);
            world.setItem(newItem);
            world.remove(item);
            this.shield = item.getItem();
            addMessage(item.getItem().getType().getName() + " equipped.");
            this.def += this.shield.getType().getDefense();
            this.eva += this.shield.getType().getEvasion();
            world.setItem(newItem);
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
            addMessage("You find a " + item.getItem().getType().getName() + ".");
        }
    }
    
    public boolean isEvil() { return this.isEvil; }
    public boolean canSee(int wx, int wy) { return ai.canSee(wx, wy); }
    public Tile getTile(int x, int y) { return world.tile(x, y); }
    public Creature getCreature(int x, int y) { return world.getCreature(x, y); }
    public String getName() { return this.name; }
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
        int atkRoll = (int) Math.floor(Math.random()*20) + 1;
        int dmgRoll = (int) Math.floor(Math.random()*5) + 1;
        if (atkRoll >= 20) {
            double r = Math.random();
            if (r<0.2)
                addMessage("Your weapon bestows your rage upon your victims!");
            else if (r<0.4)
                addMessage("You skewer the pathetic creature!");
            else if (r<0.6)
                addMessage("You just manage to pull of a devasting attack!");
            else if (r<0.8)
                addMessage("Your grandpa's flawless technique shows off in your strike!");
            else if (r<1)
                addMessage("YOU IMPALE THE LITTLE INSECT");
            other.dealDamage((dmg-other.def+5)*2);
            setRp(3);
        } else if (atkRoll <= 1) {
            double r = Math.random();
            if (r<0.2)
                addMessage("You are very MISS-leading in your combat ability.");
            else if (r<0.4)
                addMessage("Even a baby could of hit that.");
            else if (r<0.6)
                addMessage("You get an A for effort.");
            else if (r<0.8)
                addMessage("Who taught you to fight, your grandpa?");
            else if (r<1)
                addMessage("YOU SHAME YOUR FAMILY");
            setRp(-1);
        } else if (atkRoll <= 10-(atk-other.eva)) {
            double r = Math.random();
            if (r<0.2)
                addMessage("Your weapon barely grazes it. Try harder.");
            else if (r<0.4)
                addMessage("You miss.");
            else if (r<0.6)
                addMessage("You missed. Better luck next time!");
            else if (r<0.8)
                addMessage("Maybe you should train harder.");
            else if (r<1)
                addMessage("You must study more.");
        } else {
            addMessage("You strike the " + other.getName() + ".");
            other.dealDamage(dmg-other.def+dmgRoll);
            setRp(1);
        }
        if (other.getCurrentHp()<1) {
            world.remove(other);
            addMessage("The " + other.getName() + " dies!");
            setRp(1);
            setHp(1);
        }
    }

    public void update() {
        ai.update();
    }

    public void dealDamage(int damage) {
        if (damage < 1) {
            setHp(-1);
        } else {
            setHp(-damage);
        }
    }
}