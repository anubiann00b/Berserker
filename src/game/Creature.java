package game;

public class Creature {
    public Creature(int m_hp, int m_dmg, int m_attack, int m_evasion, int m_armor)
    {
        x = 0;
        y = 0;
        randomStatSet();
        //write new stats into message box
    }
    
    public getX() {
        
    }
    
    public Creature(int x, int y)
    {
        this.x = x;
        this.y = y;
        randomStatSet();
        //write new stats into message box
    }
    
    public void randomStatSet()
    {
        totalHp = (int) (Math.random()*50 + 50);
        attack = (int) (Math.random()*25 + 75);
        damage = (int) (Math.random()*25);
        evasion = (int) (Math.random()*15);
        armor = (int) (Math.random()*15);
    }
    int currentHp;
    int totalHp;
    int attack;
    int damage;
    int evasion;
    int armor;
    int x;
    int y;
}
