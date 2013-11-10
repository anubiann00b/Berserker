package game;

public enum Armor {
    STARWEAVE(0, 7),
    CLOTH(1, 5),
    LEATHER(2, 3),
    HIDE(3, 1),
    SCALE(5, -1),
    STEEL(8, -3),
    LEAD(11, -5),
    DIAMOND(14, -7);
    
    private int defense;
    public int getDefense() { return defense; }
    
    private int evasion;
    public int getEvasion() { return evasion; }
    
    Armor (int defense, int evasion)
    {
        this.defense = defense;
        this.evasion = evasion;
    }
}
