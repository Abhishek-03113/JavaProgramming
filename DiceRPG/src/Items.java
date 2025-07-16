public class Items {
    private final String itemName;
    private final int itemCost;
    private final String itemRarity;

    public Items(String itemName, int itemCost, String itemRarity) {
        this.itemName = itemName;
        this.itemCost = itemCost;
        this.itemRarity = itemRarity;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemCost() {
        return itemCost;
    }

    public String getItemRarity() {
        return itemRarity;
    }

}


