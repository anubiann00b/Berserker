package game.enumeration;

public enum Consumable {
    FIRE     ("Potion of Fire",      Status.BURN,    5),
    CHILL    ("Potion of Chill",     Status.FREEZE,  5),
    POISON   ("Potion of Poison",    Status.POISON,  3),
    CONFUSION("Potion of Confusion", Status.CONFUSE, 6),
    WEAKNESS ("Potion of Weakness",  Status.WEAKEN,  5),
    STRENGTH ("Potion of Strength",  Status.BUFF,    6),
    BERSERK  ("Potion of Berserk",   Status.BERSERK, 6),
    CURE     ("Potion of Cure",      Status.HEAL,    1),
    HEALING  ("Potion of Healing",   Status.HEAL,    1),
    ROT      ("Potion of Rot",       Status.ROT,     9);
    
    private String name;
    public String getName() { return name; }
    
    private Status status;
    public Status getStatus() { return status; }
    
    private int rarity;
    public int getRarity() { return rarity; }
    
    
    Consumable(String name, Status status, int rarity) {
        this.name = name;
        this.status = status;
        this.rarity = rarity;
    }
    
    
}
