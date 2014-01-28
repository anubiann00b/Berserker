package game.enumeration;

import asciiPanel.AsciiPanel;
import java.awt.Color;

public enum Status {
//          Name             Color                      HP Atk Dmg Eva Def Duration
    NONE    ("",              Color.BLACK,               0,  0,  0,  0,  0,  0),
    FREEZE  ("Frozen",        AsciiPanel.brightBlue,     0, -3,  0, -2,  0,  3),
    BURN    ("Burned",        AsciiPanel.yellow,         4,  0,  0,  0,  0,  1),
    POISON  ("Poisoned",      AsciiPanel.green,         -2,  0,  0,  0,  0,  6),
    CONFUSE ("Confused",      AsciiPanel.brightYellow,   0, -2,  0, -2,  0,  3),
    WEAKEN  ("Weakened",      AsciiPanel.brightBlack,    0, -1, -3, -1, -3,  2),
    BUFF    ("Strengthened",  AsciiPanel.blue,           0,  1,  1,  1,  1,  6),
    BERSERK ("Berserk",       AsciiPanel.brightMagenta,  0,  3,  6,  0,  0,  5),
    EXHAUST ("Exhausted",     AsciiPanel.magenta,        0, -1, -2,  0, -1,  0),
    BLEED   ("Bleeding",      AsciiPanel.brightRed,     -1,  0,  0,  0,  0,  8),
    HEAL    ("Healed",        AsciiPanel.brightGreen,    10, 0,  0,  0,  0,  0),
    ROT     ("Rotting",       AsciiPanel.black,         -3, -2, -2, -2, -2,  5);
    
    private String description;
    public String getDescription() { return description; }
    
    private Color color;
    public Color getColor() { return color; }
    
    private int health;
    public int getHealth() { return health; }
    
    private int attack;
    public int getAttack() { return attack; }
    
    private int damage;
    public int getDamage() { return damage; }
    
    private int evasion;
    public int getEvasion() { return evasion; }
    
    private int defense;
    public int getDefense() { return defense; }

    private int duration;
    public int getDuration() { return duration; }
    
    Status(String description, Color color, int health, int attack, int damage, int evasion, int defense, int duration)
    {
        this.description = description;
        this.color = color;
        this.health = health;
        this.attack = attack;
        this.damage = damage;
        this.evasion = evasion;
        this.defense = defense;
        this.duration = duration;
    }
}
