public class Weapon extends Items {
    private final int damage;
    private final int durability;

    public Weapon(String itemName, int itemCost, String itemRarity, int damage, int durability) {
        super(itemName, itemCost, itemRarity);
        this.damage = damage;
        this.durability = durability;
    }

    public int getDurability() {
        return durability;
    }

    public int getDamage() {
        return damage;
    }


}
