package game;
// /\|[]{}()<>

import asciiPanel.AsciiPanel;
import java.awt.Color;

public enum Equipable {
    QUICKBLADE("Quickblade", 9, 1, 0, 0, 1, ')', Color.LIGHT_GRAY),
    DAGGER("Dagger", 8, 2, 0, 0, 3, ')', AsciiPanel.brightBlue),
    SHORTSWORD("Short Sword", 7, 3, 0, 0, 5 ,')', AsciiPanel.blue),
    RAPIER("Rapier", 6, 4, 0, 0, 7, '^', Color.LIGHT_GRAY),
    MAUL("Maul", 5, 5, 0, 0, 9, '^', AsciiPanel.brightBlue),
    SWORD("Sword", 4, 6, 0, 0, 7, '^', AsciiPanel.blue),
    WARAXE("War Axe", 3, 7, 0, 0, 5, '\\', Color.LIGHT_GRAY),
    BROADSWORD("Broad Sword", 2, 8, 0, 0, 3, '\\', AsciiPanel.brightBlue),
    EXECAXE("Executioner's Axe", 1, 9, 0, 0, 1, '\\', AsciiPanel.blue),
    STARWEAVE("Starweave Armor", 0, 0, 0, 7, 1, '(', Color.LIGHT_GRAY),
    CLOTH("Cloth Armor", 0, 0, 1, 5, 3, '(', AsciiPanel.brightBlue),
    LEATHER("Leather Armor", 0, 0, 2, 3, 5, ']', Color.LIGHT_GRAY),
    HIDE("Hide Armor", 0, 0, 3, 1, 7, ']', AsciiPanel.brightBlue),
    SCALE("Scale Armor", 0, 0, 5, -1, 7, ']', AsciiPanel.blue),
    STEEL("Steel Armor", 0, 0, 8, -3, 5, '}', Color.LIGHT_GRAY),
    LEAD("Lead Armor", 0, 0, 11, -5, 3, '}', AsciiPanel.brightBlue),
    DIAMOND("Diamond Armor", 0, 0, 14, -7, 1, '}', AsciiPanel.blue),
    BUCKLER("Buckler", 0, 0, 2, 3, 2, '*', Color.LIGHT_GRAY),
    LIGHT("Light Shield", 0, 0, -1, 5, 6, '*', AsciiPanel.brightBlue),
    HEAVY("Heavy Shield", 0, 0, -3, 8, 2, '*', AsciiPanel.blue);
  
    private String name;
    public String getName() { return name; }
    
    private int attack;
    public int getAttack() { return attack; }
    
    private int damage;
    public int getDamage() { return damage; }
    
    private int defense;
    public int getDefense() { return defense; }
    
    private int evasion;
    public int getEvasion() { return evasion; }
    
    private int rarity;
    public int getRarity() { return rarity; }
    
    private char glyph;
    public char getGlyph() { return glyph; }
    
    private Color color;
    public Color getColor() { return color; }
    
    Equipable(String name, int attack, int damage, int defense, int evasion, int rarity, char glyph, Color color) {
        this.name = name;
        this.attack = attack;
        this.damage = damage;
        this.defense = defense;
        this.evasion = evasion;
        this.rarity = rarity;
        this.glyph = glyph;
        this.color = color;
    }

}
