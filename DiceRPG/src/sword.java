public class sword extends Weapon {

    public sword(String itemName, int itemCost, String itemRarity, int damage, int durability) {
        super(itemName, itemCost, itemRarity, damage, durability);
    }

    public void slash(Player player, Enemy enemy, int requiredPower){
        if (player.getPower() >= requiredPower){
            player.setPower(player.getPower() - requiredPower);
        }

    }
}
