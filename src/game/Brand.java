package game;

public enum Brand {
    POISON(),
    ELECTRICITY(),
    FIRE(),
    ICE(),
    VORPAL(),
    DRAIN(),
    PHOTODEFLECTION(),
    RAGE(),
    PROTECTION();
    
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
}
