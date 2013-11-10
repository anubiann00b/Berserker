package game;

public enum Weapons {
    QUICKBLADE(9, 1),
    DAGGER(8, 2),
    SHORTSWORD(7, 3),
    RAPIER(6, 4),
    MAUL(5, 5),
    SWORD(4, 6),
    WARAXE(3, 7),
    BROADSWORD(2, 8),
    EXECAXE(1, 9);
  
    private int attack;
    public int getAttack() { return attack; }
    
    private int damage;
    public int getDamage() { return damage; }
    
    Weapons(int attack, int damage)
    {
        this.attack = attack;
        this.damage = damage;
    }

}
