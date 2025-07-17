public class Item {
    public static int vegCounter;
    public static int nonVegCounter;

    private String name;
    private final double price;
    private final boolean isVeg;
    private final Category catergory;

    public Item(String Name, int price, boolean isVeg, Category category) {
        this.name = Name;
        this.price = price;
        this.isVeg = isVeg;
        this.catergory = category;

        if (!isVeg) {
            nonVegCounter++;
        } else {
            vegCounter++;
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);

        return "Name: " + name + " Price: " + price;
    }
}


