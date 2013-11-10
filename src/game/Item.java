package game;

public class Item {
    private String name;
    private Equipable type;
    private int atk;
    private int dmg;
    private int eva;
    private int def;
    private Brand brand;
    private static final int NUMBER_OF_BRANDS = Brand.values().length;
    private static final double BRAND_CHANCE = 0.10;
    private static final int NUMBER_OF_EQUIPABLES = Equipable.values().length;

    public Equipable getType() {
        return type;
    }
    
    public Item() {
        this.type = generateType();
        this.brand = generateBrand();
        this.name = this.type.getName();
        this.atk = this.type.getAttack() + brand.getAtk();
        this.dmg = this.type.getDefense() + brand.getDef();
        this.eva = this.type.getEvasion() + brand.getEva();
        this.def = this.type.getDefense() + brand.getDmg();
    }
    
    public Item(Equipable type, int enchant) {
        this(type, null, enchant);
    }
    
    public Item(Equipable type, Brand brand, int enchant) {
        this.name = type.getName();
        this.type = type;
        this.atk = type.getAttack();
        this.dmg = type.getDamage();
        this.eva = type.getEvasion();
        this.def = type.getDefense();
        this.brand = brand;
    }

    public Brand generateBrand() {
        if (Math.random() < BRAND_CHANCE) {
            int r = (int) Math.floor(Math.random()*NUMBER_OF_BRANDS);
            Brand[] brands = Brand.values();
            return brands[r];
        } else {
            return null;
        }
    }

    private Equipable generateType() {
        int r = (int) Math.floor(Math.random()*NUMBER_OF_EQUIPABLES);
        Equipable[] equipables = Equipable.values();
        return equipables[r];
    }
}
