import java.util.Set;

public class Player {
    private String playerName;
    private Class playerClass;
    private Integer Health;
    private Integer gold;
    private Set<Items> inventory;

    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    private int playerLevel;
    private int attack;
    private int defense;
    private int power;
    private int speed;
    private int potionEffect;

    public Player(String playerName, Class playerClass) {
        this.playerName = playerName;
        this.playerClass = playerClass;
        playerLevel = 1;
        this.Health = playerClass.getHealth();
        this.attack = playerClass.getAttack();
        this.defense = playerClass.getDefense();
        this.power = playerClass.getPower();
        this.speed = playerClass.getSpeed();
    }

    public int getPotionEffect() {
        return potionEffect;
    }

    public void setPotionEffect(int potionEffect) {
        this.potionEffect = potionEffect;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public Set<Items> getInventory() {
        return inventory;
    }

    public void setInventory(Set<Items> inventory) {
        this.inventory = inventory;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Integer getHealth() {
        return Health;
    }

    public void setHealth(Integer health) {
        Health = health;
    }

    public Class getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(Class playerClass) {
        this.playerClass = playerClass;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }


    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
