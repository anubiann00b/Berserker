package game;
// /\|[]{}()<>

import asciiPanel.AsciiPanel;
import java.awt.Color;

public enum Equipable {
// Weapons                Name  Atk Dmg Def Eva Rare Char   Color                Type
    STICK               ("Stick", 1,  1,  0,  0,  0, '/',  Color.DARK_GRAY,        0),
    QUICKBLADE     ("Quickblade", 11, 1,  0,  0,  2, ')',  AsciiPanel.brightBlue,  0),
    DAGGER             ("Dagger", 10, 2,  0,  0,  3, ')',  AsciiPanel.brightBlue,  0),
    SHORTSWORD    ("Short Sword", 8,  3,  0,  0,  4, ')',  AsciiPanel.brightBlue,  0),
    RAPIER             ("Rapier", 7,  4,  0,  0,  5, '^',  Color.LIGHT_GRAY,       0),
    MAUL                 ("Maul", 5,  5,  0,  0,  4, '^',  Color.LIGHT_GRAY,       0),
    SWORD               ("Sword", 4,  7,  0,  0,  5, '^',  Color.LIGHT_GRAY,       0),
    WARAXE            ("War Axe", 3,  8,  0,  0,  4, '\\', AsciiPanel.blue,        0),
    BROADSWORD    ("Broad Sword", 2,  10, 0,  0,  3, '\\', AsciiPanel.blue,        0),
    EXECAXE ("Executioner's Axe", 1,  11, 0,  0,  2, '\\', AsciiPanel.blue,        0),
    
// Armors                 Name  Atk Dmg Def Eva Rare Char   Color                Type
    SHIRT               ("Shirt", 0,  0,  0,  0,  0, ')',  Color.DARK_GRAY,        1),
    STARWEAVE ("Starweave Armor", 0,  0,  1,  12, 1, ')',  AsciiPanel.brightBlue,  1),
    CLOTH         ("Cloth Armor", 0,  0,  2,  8,  3, ')',  AsciiPanel.brightBlue,  1),
    LEATHER     ("Leather Armor", 0,  0,  3,  6,  4, ']',  Color.LIGHT_GRAY,       1),
    HIDE           ("Hide Armor", 0,  0,  4,  5,  4, ']',  Color.LIGHT_GRAY,       1),
    SCALE         ("Scale Armor", 0,  0,  5,  4,  4, ']',  Color.LIGHT_GRAY,       1),
    STEEL         ("Steel Armor", 0,  0,  7,  2,  3, '}',  AsciiPanel.blue,        1),
    LEAD           ("Lead Armor", 0,  0,  9,  0,  1, '}',  AsciiPanel.blue,        1),
    DIAMOND     ("Diamond Armor", 0,  0,  12, 1,  1, '}',  AsciiPanel.blue,        1),
    
// Shields                Name  Atk Dmg Def Eva Rare Char   Color                Type
    LONGSLEEVES  ("Long Sleeves", 0,  0,  0,  0,  0, '*',  Color.DARK_GRAY,        2),
    BUCKLER           ("Buckler", 0,  0,  2,  7,  2, '*',  AsciiPanel.brightBlue,  2),
    LIGHT        ("Light Shield", 0,  0,  4,  4,  6, '*',  Color.LIGHT_GRAY,       2),
    HEAVY        ("Heavy Shield", 0,  0,  7,  2,  2, '*',  AsciiPanel.blue,        2);
  
    private String name;
    private int atk;
    private int dmg;
    private int def;
    private int eva;
    private int rarity;
    private char glyph;
    private Color color;
    private int type;
    
    Equipable(String name, int atk, int dmg, int def, int eva, int rarity, char glyph, Color color, int type) {
        this.name = name;
        this.atk = atk;
        this.dmg = dmg;
        this.def = def;
        this.eva = eva;
        this.rarity = rarity;
        this.glyph = glyph;
        this.color = color;
        this.type = type;
    }
    
    public String getName() { return name; }
    public int getAtk() { return atk; }
    public int getDmg() { return dmg; }
    public int getDef() { return def; }
    public int getEva() { return eva; }
    public int getRarity() { return rarity; }
    public char getGlyph() { return glyph; }
    public Color getColor() { return color; }
    public int getType() { return type; }
}
