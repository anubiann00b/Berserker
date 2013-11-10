package game;
// /\|[]{}()<>
public enum Equipable {
    QUICKBLADE("Quickblade", 9, 1, 0, 0, 1),
    DAGGER("Dagger", 8, 2, 0, 0, 3),
    SHORTSWORD("Short Sword", 7, 3, 0, 0, 5),
    RAPIER("Rapier", 6, 4, 0, 0, 7),
    MAUL("Maul", 5, 5, 0, 0, 9),
    SWORD("Sword", 4, 6, 0, 0, 7),
    WARAXE("War Axe", 3, 7, 0, 0, 5),
    BROADSWORD("Broad Sword", 2, 8, 0, 0, 3),
    EXECAXE("Executioner's Axe", 1, 9, 0, 0, 1),
    STARWEAVE("Starweave Armor", 0, 0, 0, 7, 1),
    CLOTH("Cloth Armor", 0, 0, 1, 5, 3),
    LEATHER("Leather Armor", 0, 0, 2, 3, 5),
    HIDE("Hide Armor", 0, 0, 3, 1, 7),
    SCALE("Scale Armor", 0, 0, 5, -1, 7),
    STEEL("Steel Armor", 0, 0, 8, -3, 5),
    LEAD("Lead Armor", 0, 0, 11, -5, 3),
    DIAMOND("Diamond Armor", 0, 0, 14, -7, 1),
    BUCKLER("Buckler Shield", 0, 0, 2, 3, 2),
    LIGHT("Light Shield", 0, 0, -1, 5, 6),
    HEAVY("Heavy Shield", 0, 0, -3, 8, 2);
  
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
    public int getGlyph() { return rarity; }
    
    Equipable(String name, int attack, int damage, int defense, int evasion, int rarity, char glyph)
    {
        this.name = name;
        this.attack = attack;
        this.damage = damage;
        this.defense = defense;
        this.evasion = evasion;
        this.rarity = rarity;
        this.glyph = glyph;
    }

}
