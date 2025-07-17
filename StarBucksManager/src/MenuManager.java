import java.util.Set;

public class MenuManager {
    private Set<Item> items;

    public void addItemToMenu(Item itemName){
        items.add(itemName);
    }

    public void removeItemFromMenu(Item itemName){
        items.remove(itemName);
    }


}