public class Items {
    private final String itemName;
    private final int itemCost;
    private final String itemRarity;

    public Items(String itemName, int itemCost, String itemRarity) {
        this.itemName = itemName;
        this.itemCost = itemCost;
        this.itemRarity = itemRarity;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemCost() {
        return itemCost;
    }

    public String getItemRarity() {
        return itemRarity;
    }

}


class Weapon extends Items {
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

class healingPotion extends Items {
    private final int potionSize;

    public healingPotion(String itemName, int itemCost, String itemRarity, int potionSize) {
        super(itemName, itemCost, itemRarity);
        this.potionSize = potionSize;
    }

    public void Heal(Player player) {
        player.setHealth(player.getHealth() + potionSize);
    }
}


class ragePotion extends Items {
    public ragePotion(String itemName, int itemCost, String itemRarity, int potionSize) {
        super(itemName, itemCost, itemRarity);
    }

    public void Rage(Player player) {
        player.setAttack(player.getAttack() + 50);
        player.setPotionEffect(5);
    }
}

class sword extends Weapon {

    public sword(String itemName, int itemCost, String itemRarity, int damage, int durability) {
        super(itemName, itemCost, itemRarity, damage, durability);
    }

    public void slash(Player player, Enemy enemy, int requiredPower){
        if (player.getPower() >= requiredPower){
            player.setPower(player.getPower() - requiredPower);
        }

    }
}

class bow extends Weapon {
    public bow(String itemName, int itemCost, String itemRarity, int damage, int durability) {
        super(itemName, itemCost, itemRarity, damage, durability);
    }

    public void shootArrow(Player player, Enemy enemy, int requiredPower) {}
}

class staff extends Weapon {
    public staff(String itemName, int itemCost, String itemRarity, int damage, int durability) {
        super(itemName, itemCost, itemRarity, damage, durability);
    }

    public void fireBall(Player player,  Enemy enemy, int requiredPower){

    }
}

