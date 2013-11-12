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

    public Equipable getEquipable() { return type; }
    public Brand getBrand() { return brand; }
    
    public Item() {
        this.type = generateType();
        this.brand = generateBrand();
        this.name = this.type.getName();
        this.atk = this.type.getAtk() + brand.getAtk();
        this.dmg = this.type.getDef() + brand.getDef();
        this.eva = this.type.getEva() + brand.getEva();
        this.def = this.type.getDef() + brand.getDmg();
    }
    
    public Item(Equipable type, int enchant) {
        this(type, null, enchant);
    }
    
    public Item(Equipable type, Brand brand, int enchant) {
        this.name = type.getName();
        this.type = type;
        this.atk = type.getAtk();
        this.dmg = type.getDmg();
        this.eva = type.getEva();
        this.def = type.getDef();
        this.brand = brand;
    }

    public Brand generateBrand() {
        if (Math.random() < BRAND_CHANCE) {
            int r = (int) Math.floor(Math.random()*NUMBER_OF_BRANDS);
            Brand[] brands = Brand.values();
            return brands[r];
        } else {
            return Brand.NONE;
        }
    }

    private Equipable generateType() {
        int r = (int) Math.floor(Math.random()*NUMBER_OF_EQUIPABLES);
        Equipable[] equipables = Equipable.values();
        
       return equipables[r];
       
    }
}
