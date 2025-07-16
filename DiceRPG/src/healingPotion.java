public class healingPotion extends Items {
    private final int potionSize;

    public healingPotion(String itemName, int itemCost, String itemRarity, int potionSize) {
        super(itemName, itemCost, itemRarity);
        this.potionSize = potionSize;
    }

    public void Heal(Player player) {
        player.setHealth(player.getHealth() + potionSize);
    }
}
