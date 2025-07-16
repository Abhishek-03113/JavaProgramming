public class Archer extends Class{
    public Archer(Player player, String className, int health, int attack, int defense, int power, int speed, Bow bow) {
        super(player, className, health, attack, defense, power, speed, bow);

    }


    void ShootArrow(Player player, Enemy enemy, Bow bow){
        int requiredPower = 5;

        if( player.getPower() >= requiredPower){
            enemy.setHealth(enemy.getHealth() - bow.getDamage());
            player.setPower(player.getPower() - requiredPower);
        }

    }
}
