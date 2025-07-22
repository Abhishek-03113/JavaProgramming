import java.util.ArrayList;
import java.util.HashSet;

public class Hero {
    private String heroName;
    private int heroLevel = 1;

    public int getHeroHealth() {
        return heroHealth;
    }

    public void setHeroHealth(int heroHealth) {
        this.heroHealth = heroHealth;
    }

    private int heroHealth = 100;
    private int heroExperience = 0;
    private ArrayList<Item> inventory;

    public  Hero(String heroName) {
        this.heroName = heroName;
        this.inventory = new ArrayList<>();
    }

}