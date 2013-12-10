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
    private static final double BRAND_CHANCE = 0.25;
    private static final int NUMBER_OF_EQUIPABLES = Equipable.values().length;
    
    public Item() {
        this.type = generateType();
        this.brand = generateBrand();
        this.name = generateName(this.brand);
        this.atk = this.type.getAtk() + brand.getAtk();
        this.dmg = this.type.getDmg() + brand.getDmg();
        this.eva = this.type.getEva() + brand.getEva();
        this.def = this.type.getDef() + brand.getDef();
    }
    
    public Item(Equipable type) {
        this(type, Brand.NONE);
    }
    
    public Item(Equipable type, Brand brand) {
        this.brand = brand;
        this.type = type;
        this.name = generateName(this.brand);
        this.atk = this.type.getAtk() + brand.getAtk();
        this.dmg = this.type.getDef() + brand.getDef();
        this.eva = this.type.getEva() + brand.getEva();
        this.def = this.type.getDef() + brand.getDmg();
    }
    
    public String getName() { return name; }
    public Equipable getEquipable() { return type; }
    public Brand getBrand() { return brand; }
    public int getAtk() { return atk; }
    public int getDmg() { return dmg; }
    public int getDef() { return def; }
    public int getEva() { return eva; }
    
    public Brand generateBrand() {
        if (Math.random() < BRAND_CHANCE && type.getType() == 0) {
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
    
    private String generateName(Brand brand) {
        if(brand!=Brand.NONE)
            return this.type.getName() + " of " + this.brand.getName();
        return this.type.getName();
    }
}
