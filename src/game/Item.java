package game;

public class Item {
    private String name;
    private int atk;
    private int dmg;
    private int eva;
    private int def;
    private Brand brand;
    
    public Item(Equipable type, int enchant) {
        this(type, null, enchant);
    }
    
    public Item(Equipable type, Brand brand, int enchant) {
        this.name = type.getName();
        this.atk = type.getAttack();
        this.dmg = type.getDamage();
        this.eva = type.getEvasion();
        this.def = type.getDefense();
        this.brand = brand;
    }
}
