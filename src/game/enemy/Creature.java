package game.enemy;

import game.enemy.ai.CreatureAi;
import game.item.Item;
import game.player.Player;
import game.world.Tile;
import game.world.World;
import java.awt.Color;

public class Creature implements Alive {
    private int x;
    private int y;
    private int maxHp;
    private int currentHp;
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
    
    public Creature(String name, World world, char glyph, Color color, int maxHp, int baseStats) {
        this.name = name;
        this.world = world;
        this.glyph = glyph;
        this.color = color;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.visionRadius = 9;
        atk = baseStats;
        dmg = baseStats;
        eva = baseStats;
        def = baseStats;
        isEvil = true;
    }
    
    public int getX() { return this.x; }    
    public int getY() { return this.y; }
    public int getCurrentHp() { return this.currentHp; }    
    public int getMaxHp() { return this.maxHp; }    
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

    public Tile getTile(int x, int y) { return world.tile(x, y); }
    public Creature getCreature(int x, int y) { return world.getCreature(x, y); }

    public void setX(int x) { this.x = x; }    
    public void setY(int y) { this.y = y; }
    public void setAtk(int atk) { this.atk += atk; }    
    public void setDmg(int dmg) { this.dmg += dmg; }
    public void setEva(int eva) { this.eva += eva; }    
    public void setDef(int def) { this.def += def; }
    public void setHp(int hp) { this.currentHp = Math.max(0,Math.min(currentHp+hp,maxHp)); }
    public void setCreatureAi(CreatureAi ai) { this.ai = ai; }
    public void update() {
        ai.update();
    }
    public void dealDamage(int dmg) { setHp(Math.min(-dmg,-1)); }
    public boolean canSee(int wx, int wy) { return ai.canSee(wx, wy); }
    
    public void moveBy(int mx, int my) {
        Creature otherCreature = world.getCreature(x+mx, y+my);
        Player otherPlayer = world.getPlayer(x+mx, y+my);
        if (otherCreature == null && otherPlayer == null) {
            ai.onEnter(x+mx, y+my, world.tile(x+mx, y+my));
        } else if (otherPlayer!=null) {
            attack(otherPlayer);
        }
    }

    private void attack(Player other) {
        int attackRoll = 1 + (int) (Math.random()*20);
        int attackVal = (int) attackRoll*(this.atk-other.getEva());
        int damageVal = (int) Math.max(Math.floor(Math.random()*(this.dmg-other.getDef())),1);
        if (attackRoll == 20) {
            ai.addCritMessage(other);
            other.dealDamage(damageVal*2);
        } else if (attackRoll == 1) {
            ai.addCritMissMessage(other);
        } else if (attackVal < 5) {
            ai.addMissMessage(other);
        } else {
            ai.addHitMessage(other);
            other.dealDamage(damageVal);
        }
    }
}