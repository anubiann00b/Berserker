package game.enumeration;

public enum Brand {
// Brands                   Name    Status      Atk Dmg Eva Def
    NONE                      ("", Status.NONE,   0,  0,  0,  0),
    POISON              ("Poison", Status.POISON, 0,  0,  0,  0),
    FIRE                  ("Fire", Status.BURN,   0,  0,  0,  0),
    ICE                    ("Ice", Status.FREEZE, 0,  0,  0,  0),
    ELECTRICITY    ("Electricity", null,          1,  3,  0,  0),
    VORPAL           ("Sharpness", null,          4,  5,  0,  0),
    PHOTODEFLECTION ("Deflection", null,          1,  0,  4,  1),
    PROTECTION      ("Protection", null,          0,  0,  1,  5);
    
    private String name;
    public String getName() { return name; }
    
    private Status status;
    public Status getStatus() { return status; }
    
    private int atk;
    public int getAtk() { return atk; }
    
    private int dmg;
    public int getDmg() { return dmg; } 
    
    private int eva;
    public int getEva() { return eva; }
    
    private int def;
    public int getDef() { return def; }
    
    Brand(String name, Status status, int atk, int dmg, int eva, int def) {
        this.name = name;
        this.status = status;
        this.atk = atk;
        this.dmg = dmg;
        this.eva = eva;
        this.def = def;        
    }
}
