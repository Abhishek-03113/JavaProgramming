public abstract class Class {
    private String className;
    private int health;
    private int attack;
    private int defense;
    private final Player player;
    private int speed;
    private int power;
    private Weapon weapon;

    public Class(Player player, String className, int health, int attack, int defense, int power, int speed, Weapon weapon) {
        this.className = className;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.power = power;
        this.weapon = weapon;
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
    }
}
