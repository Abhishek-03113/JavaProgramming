public class Enemy {
    private String enemyName;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    private int health;
    private int enemyLevel;
    private int attack;
    private int defense;
    private int power;
    private int speed;

    public Enemy(String enemyName, int enemyLevel) {
        this.enemyName = enemyName;
        this.enemyLevel = enemyLevel;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public int getEnemyLevel() {
        return enemyLevel;
    }

    public void setEnemyLevel(int enemyLevel) {
        this.enemyLevel = enemyLevel;
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
        this.speed = speed;
    }
}



class Zombie extends Enemy{
    public Zombie(String enemyName, int enemyLevel) {
        super(enemyName, enemyLevel);
        this.setAttack(10);
        this.setDefense(20);
        this.setPower(10);
        this.setSpeed(5);
        this.setHealth(20);
    }
}