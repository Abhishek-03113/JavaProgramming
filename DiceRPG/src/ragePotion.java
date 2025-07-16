public class ragePotion extends Items {
    public ragePotion(String itemName, int itemCost, String itemRarity, int potionSize) {
        super(itemName, itemCost, itemRarity);
    }

    public void Rage(Player player) {
        player.setAttack(player.getAttack() + 50);
        player.setPotionEffect(5);
    }
}
