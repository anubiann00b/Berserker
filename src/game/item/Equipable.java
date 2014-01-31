package game.item;
// /\|[]{}()<>

public enum Equipable {
    
// Weapons                Name  Atk Dmg Def Eva Rare Char Type
    STICK               ("Stick", 1,  1,  0,  0,  0, '/',  0),
    QUICKBLADE     ("Quickblade", 11, 1,  0,  0,  2, ')',  0),
    DAGGER             ("Dagger", 10, 2,  0,  0,  3, ')',  0),
    SHORTSWORD    ("Short Sword", 8,  3,  0,  0,  4, ')',  0),
    RAPIER             ("Rapier", 7,  4,  0,  0,  5, '^',  0),
    MAUL                 ("Maul", 5,  5,  0,  0,  4, '^',  0),
    SWORD               ("Sword", 4,  7,  0,  0,  5, '^',  0),
    WARAXE            ("War Axe", 3,  8,  0,  0,  4, '\\', 0),
    BROADSWORD    ("Broad Sword", 2,  10, 0,  0,  3, '\\', 0),
    WARHAMMER       ("Warhammer", 1,  11, 0,  0,  2, '\\', 0),
    
// Armors                 Name  Atk Dmg Def Eva Rare Char Type
    SHIRT               ("Shirt", 0,  0,  0,  0,  0, ')',  1),
    STARWEAVE ("Starweave Armor", 0,  0,  1,  12, 1, ')',  1),
    CLOTH         ("Cloth Armor", 0,  0,  2,  8,  3, ')',  1),
    LEATHER     ("Leather Armor", 0,  0,  3,  6,  4, ']',  1),
    HIDE           ("Hide Armor", 0,  0,  4,  5,  4, ']',  1),
    SCALE         ("Scale Armor", 0,  0,  5,  4,  4, ']',  1),
    STEEL         ("Steel Armor", 0,  0,  7,  2,  3, '}',  1),
    LEAD           ("Lead Armor", 0,  0,  9,  0,  1, '}',  1),
    DIAMOND     ("Diamond Armor", 0,  0,  12, 1,  1, '}',  1),
    
// Shields                Name  Atk Dmg Def Eva Rare Char Type
    LONGSLEEVES  ("Long Sleeves", 0,  0,  0,  0,  0, '*',  2),
    BUCKLER           ("Buckler", 0,  0,  2,  7,  2, '*',  2),
    LIGHT        ("Light Shield", 0,  0,  4,  4,  6, '*',  2),
    HEAVY        ("Heavy Shield", 0,  0,  7,  2,  2, '*',  2);
  
    private String name;
    private int atk;
    private int dmg;
    private int def;
    private int eva;
    private int rarity;
    private char glyph;
    private int type;
    
    Equipable(String name, int atk, int dmg, int def, int eva, int rarity, char glyph, int type) {
        this.name = name;
        this.atk = atk;
        this.dmg = dmg;
        this.def = def;
        this.eva = eva;
        this.rarity = rarity;
        this.glyph = glyph;
        this.type = type;
    }
    
    public String getName() { return name; }
    public int getAtk() { return atk; }
    public int getDmg() { return dmg; }
    public int getDef() { return def; }
    public int getEva() { return eva; }
    public int getRarity() { return rarity; }
    public char getGlyph() { return glyph; }
    public int getType() { return type; }
}
