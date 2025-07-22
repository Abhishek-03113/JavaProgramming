public class Enemy {
    private String enemyName;
    private int enemyLevel;
    private int experienceDrop;

    public Enemy(String enemyName){
        this.enemyName = enemyName;
        this.enemyLevel = 5;
        this.experienceDrop = 50;
    }
    public Enemy(String enemyName, int enemyLevel){
        this.enemyName = enemyName;
        this.enemyLevel = enemyLevel;
    }

    public Enemy(String enemyName, int enemyLevel, int experienceDrop){
        this.enemyLevel = enemyLevel;
        this.experienceDrop = experienceDrop;
        this.enemyName = enemyName;
    }
}


public class Zombie extends Enemy{
    private int health = 100;
    private int damage = 25;
    private int experienceDrop = 100;

    public Zombie(String enemyName, int enemyLevel){
        super(enemyName, enemyLevel);
    }

    public void slash(Hero hero){

        hero.setHealth(hero.getHealth()- this.damage);
    }
}