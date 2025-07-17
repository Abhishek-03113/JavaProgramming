public class Archer extends Class{
    static String CLASSNAME = "Archer";
    static int HEALTH = 50;
    static int ATTACK = 25;
    static int DEFENSE = 25;
    static int POWER = 25;
    static int SPEED = 10;
    static Weapon bow = new Bow("Bow", 100, "common", 5,50);
    public Archer() {
        super(CLASSNAME, HEALTH, ATTACK, DEFENSE, POWER, SPEED, bow);
    }

    void ShootArrow(Player player, Enemy enemy, Bow bow){
        int requiredPower = 5;

        if( player.getPower() >= requiredPower){
            enemy.setHealth(enemy.getHealth() - bow.getDamage());
            player.setPower(player.getPower() - requiredPower);
        }
    }
}
