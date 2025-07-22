public class Item {
    private String itemName;
    private String itemDescription;
    private Rarity itemRarity;

    public Item(String itemName){
        this.itemName = itemName;
        this.itemDescription = "";
        this.itemRarity = Rarity.COMMON;
    }

    public Item(String itemName, String itemDescription, Rarity itemRarity) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemRarity = itemRarity;
    }

    public Item(String itemName, Rarity itemRarity) {
        this.itemName = itemName;
        this.itemDescription = "";
        this.itemRarity = itemRarity;
    }


}
