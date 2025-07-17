import java.util.Map;

public class Order {
    static int orderCount = 0;
    private final int orderID;
    private int timeOrder;
    private final double orderValue;

    public Map<Item, Integer> getItems() {
        return items;
    }

    private final Map<Item, Integer> items;

    public Order(int orderID, Map<Item, Integer> items) {
        this.items = items;
        this.orderID = orderID;
        this.orderValue = calculateOrderValue(items);
        orderCount++;
    }

    public double calculateOrderValue(Map<Item, Integer> items) {
        double cost = 0;
        cost = items.keySet().stream().mapToDouble(item -> items.get(item) * item.getPrice()).sum();
        return cost;
    }
    public double getOrderValue() {
        return orderValue;
    }


}