package game;

public enum Brand {
    NONE(Status.NONE,0,0,0,0),
    POISON(Status.POISON,0,0,0,0),
    ELECTRICITY(null,1,3,0,0),
    FIRE(Status.BURN,0,0,0,0),
    ICE(Status.FREEZE,0,0,0,0),
    VORPAL(null,4,5,0,0),
    PHOTODEFLECTION(null,1,0,4,1),
    //PSYCHOANALYSIS(),
    PROTECTION(null,0,0,1,5);
        
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
    
    Brand(Status status, int atk, int dmg, int eva, int def) {
        this.status = status;
        this.atk = atk;
        this.dmg = dmg;
        this.eva = eva;
        this.def = def;        
    }
}
